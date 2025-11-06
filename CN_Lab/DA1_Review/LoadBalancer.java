import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * LoadBalancer with:
 *  - Round Robin and Least Connections modes
 *  - Periodic health checks
 *  - Automatic failover if a backend goes down
 */
public class LoadBalancer {
    private static final int LISTEN_PORT = 8000;

    // Configure backend servers
    private static final List<InetSocketAddress> backendServers = Arrays.asList(
            new InetSocketAddress("localhost", 9001),
            new InetSocketAddress("localhost", 9002),
            new InetSocketAddress("localhost", 9003)
    );

    private static final Map<InetSocketAddress, Integer> activeConnections = new ConcurrentHashMap<>();
    private static final Map<InetSocketAddress, Boolean> backendHealthy = new ConcurrentHashMap<>();

    private static final ExecutorService clientPool = Executors.newCachedThreadPool();
    private static final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private static int currentServerIndex = 0;

    private static final String MODE = "roundrobin"; // or "roundrobin"
    private static final int HEALTH_CHECK_INTERVAL_SECONDS = 5;
    private static final int HEALTH_CHECK_TIMEOUT_MS = 1000;

    public static void main(String[] args) throws IOException {

        //for initialization purpose.
        for (InetSocketAddress s : backendServers) {
            activeConnections.put(s, 0);
            backendHealthy.put(s, false);
        }

        // Start background health checker
        scheduler.scheduleAtFixedRate(LoadBalancer::runHealthChecks, 0,
                HEALTH_CHECK_INTERVAL_SECONDS, TimeUnit.SECONDS);

        ServerSocket serverSocket = new ServerSocket(LISTEN_PORT);
        System.out.println("Load Balancer started on port " + LISTEN_PORT + " (" + MODE.toUpperCase() + " mode)");
        System.out.println("Backends: " + backendServers);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            clientPool.submit(() -> handleClient(clientSocket));
        }
    }

    private static void runHealthChecks() {
        for (InetSocketAddress backend : backendServers) {
            boolean healthy = checkBackend(backend);
            boolean previous = backendHealthy.getOrDefault(backend, false);
            backendHealthy.put(backend, healthy);
            if (healthy != previous) {
                System.out.println("Health change: " + backend + " → " + (healthy ? "HEALTHY" : "UNHEALTHY"));
            }
        }
    }

    private static boolean checkBackend(InetSocketAddress backend) {
        try (Socket s = new Socket()) {
            s.connect(new InetSocketAddress(backend.getHostName(), backend.getPort()), HEALTH_CHECK_TIMEOUT_MS);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            while (!clientSocket.isClosed()) {
                InetSocketAddress backend = getNextServer();
                if (backend == null) {
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    out.println("No backend available, please try later.");
                    clientSocket.close();
                    return;
                }

                incrementConnectionCount(backend);

                try (Socket backendSocket = new Socket()) {
                    backendSocket.connect(new InetSocketAddress(backend.getHostName(), backend.getPort()), 2000);
                    System.out.println("Forwarding client " + clientSocket.getRemoteSocketAddress() + " to " + backend +
                            " (active=" + activeConnections.get(backend) + ")");

                    // Start forwarding threads
                    Thread clientToBackend = new Thread(() -> forwardWithFailover(clientSocket, backendSocket));
                    Thread backendToClient = new Thread(() -> forward(backendSocket, clientSocket));

                    clientToBackend.start();
                    backendToClient.start();

                    clientToBackend.join();
                    backendToClient.join();

                    // If forwarding completes without exception, break the loop
                    break;

                } catch (IOException e) {
                    System.err.println("Backend " + backend + " failed. Trying another backend...");
                    // retry with next healthy backend
                } finally {
                    decrementConnectionCount(backend);
                }
            }
        } catch (Exception e) {
            System.err.println("Client error: " + e.getMessage());
        } finally {
            try { clientSocket.close(); } catch (IOException ignored) {}
        }
    }

    private static void forwardWithFailover(Socket client, Socket backend) {
        try (
                InputStream in = client.getInputStream();
                OutputStream out = backend.getOutputStream()
        ) {
            byte[] buffer = new byte[4096];
            int len;
            while ((len = in.read(buffer)) != -1) {
                try {
                    out.write(buffer, 0, len);
                    out.flush();
                } catch (IOException e) {
                    // Backend failed mid-connection
                    System.err.println("Backend failed mid-forward. Retrying...");
                    backend.close();
                    // Re-route to another backend
                    InetSocketAddress newBackend = getNextServer();
                    if (newBackend != null) {
                        incrementConnectionCount(newBackend);
                        try (Socket newBackendSocket = new Socket(newBackend.getHostName(), newBackend.getPort())) {
                            System.out.println("Failover: forwarding client " + client.getRemoteSocketAddress() +
                                    " to " + newBackend);
                            forwardWithFailover(client, newBackendSocket);
                        } catch (IOException ignored) {}
                        decrementConnectionCount(newBackend);
                    }
                    break;
                }
            }
        } catch (IOException ignored) {}
    }

    private static void forward(Socket from, Socket to) {
        try (InputStream in = from.getInputStream(); OutputStream out = to.getOutputStream()) {
            byte[] buffer = new byte[4096];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
                out.flush();
            }
        } catch (IOException ignored) {}
    }

    private static synchronized InetSocketAddress getNextServer() {
        List<InetSocketAddress> healthy = getHealthyBackends();
        if (healthy.isEmpty()) healthy = new ArrayList<>(backendServers);

        if (MODE.equalsIgnoreCase("leastconnection")) {
            return healthy.stream()
                    .min(Comparator.comparingInt(b -> activeConnections.getOrDefault(b, 0)))
                    .orElse(null);
        } else {
            InetSocketAddress server = healthy.get(currentServerIndex % healthy.size());
            currentServerIndex = (currentServerIndex + 1) % healthy.size();
            return server;
        }
    }

    private static List<InetSocketAddress> getHealthyBackends() {
        List<InetSocketAddress> list = new ArrayList<>();
        for (InetSocketAddress b : backendServers) {
            if (backendHealthy.getOrDefault(b, false)) list.add(b);
        }
        return list;
    }

    private static synchronized void incrementConnectionCount(InetSocketAddress backend) {
        activeConnections.put(backend, activeConnections.getOrDefault(backend, 0) + 1);
    }

    private static synchronized void decrementConnectionCount(InetSocketAddress backend) {
        activeConnections.put(backend, Math.max(0, activeConnections.getOrDefault(backend, 0) - 1));
    }
}
