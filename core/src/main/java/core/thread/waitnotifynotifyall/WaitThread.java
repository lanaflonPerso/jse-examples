package core.thread.waitnotifynotifyall;

public class WaitThread implements Runnable {

    private Message objectForCommunication;

    public WaitThread(Message m) {
        this.objectForCommunication = m;
    }

    @Override
    public void run() {
        synchronized (objectForCommunication) {
            System.out.println(Thread.currentThread().getName() + " has obtain the monitor");
            try {
                Thread.sleep(5000);
                objectForCommunication.wait();
                System.out.println(Thread.currentThread().getName() + " processed: " + objectForCommunication.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}