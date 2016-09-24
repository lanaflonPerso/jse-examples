package core.thread.interrupt;

public class InterruptThreadMain {
    public static void main(String...args) {
        Thread thread = new Thread(new InterruptThread());
        thread.start();
        thread.interrupt();
    }
}
