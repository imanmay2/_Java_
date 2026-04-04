public class ThreadSleep {
    public static void main(String args[]){
        System.out.println("Waiting for 5 Seconds...");
        try{
            Thread.sleep(5000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("I ");
    }
}
