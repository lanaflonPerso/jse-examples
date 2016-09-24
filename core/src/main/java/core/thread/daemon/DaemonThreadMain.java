package core.thread.daemon;

public class DaemonThreadMain {
    public static void main(String...args) throws InterruptedException {
        daemonThread();
        nonDaemonThread();
        Thread.sleep(30000);
        System.out.println(Thread.currentThread().getName() + " is going to die");
    }

    public static void daemonThread() {
        Thread daemonThread = new Thread(new DaemonThread("My life dependent on User Thread's"), "Daemon Thread");
        daemonThread.setDaemon(true);
        daemonThread.start();
    }

    public static void nonDaemonThread() {
        Thread daemonThread = new Thread(new DaemonThread("My life do not dependent on User Thread's"),
                "Non Daemon Thread");
        daemonThread.start();
    }
}