package core.thread.interrupt;

public class InterruptThread implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException intException) {
            intException.printStackTrace();
        } finally {
            System.out.println("finally executed");
        }
    }
}
