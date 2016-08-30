package core.thread.waitnotifynotifyall;

public class NotifierThread implements Runnable {

    private Message msg;

    public NotifierThread(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started");
        try {
            Thread.sleep(5000);
            synchronized (msg) {
                msg.setMsg(name + " NotifierThread work done");
                msg.notify();
                Thread.sleep(600000);
                // msg.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}