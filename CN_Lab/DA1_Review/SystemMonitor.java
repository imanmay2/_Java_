import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public class SystemMonitor {

    public static String getSystemUsage() {
        OperatingSystemMXBean osBean = (OperatingSystemMXBean)
ManagementFactory.getOperatingSystemMXBean();

        double processCpuLoad = osBean.getProcessCpuLoad() * 100;
        double systemCpuLoad = osBean.getSystemCpuLoad() * 100;

        Runtime runtime = Runtime.getRuntime();
        long usedMemory = (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
        long totalMemory = runtime.totalMemory() / (1024 * 1024);
        long maxMemory = runtime.maxMemory() / (1024 * 1024);

        return String.format(
            "CPU(Process): %.2f%% | CPU(System): %.2f%% | Used Memory: %dMB / %dMB (Max: %dMB)",
            processCpuLoad, systemCpuLoad, usedMemory, totalMemory, maxMemory
        );
    }
}
