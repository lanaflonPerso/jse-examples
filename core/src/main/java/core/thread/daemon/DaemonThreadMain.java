package core.thread.daemon;

public class DaemonThreadMain {
    public static void main(String... args) throws InterruptedException {
        Thread daemonThread = new Thread(new DaemonThread(), "Daemon Thread");
        daemonThread.setDaemon(true);
        daemonThread.start();
        Thread.sleep(30000);
        System.out.println(Thread.currentThread().getName() + "is going to die");
    }
}