package core.thread.shutdownhook;

public class ShutdownHookMain {
    public static void main(String...args) {
        ShutdownHook shutdownHook = new ShutdownHook();
        shutdownHook.attachShutDownHook();

        // Thread Execution
        Thread thread = new Thread(new UserThread());
        thread.start();
        System.out.println(Thread.currentThread().getName());
    }

}
