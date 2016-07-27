package core.thread.communication;

public class WaitThread implements Runnable {

    private Message objectForCommunication;

    public WaitThread(Message m) {
        this.objectForCommunication = m;
    }

    @Override
    public void run() {
        synchronized (objectForCommunication) {
            try {
                objectForCommunication.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " processed: " + objectForCommunication.getMsg());
        }
    }
}