package core.thread.executor.rejectionhandler;

/*
 * This is HashMapCustom user thread with separate task method
 */
public class UserThread implements Runnable {

    private String command;

    public UserThread(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
        task();
        System.out.println(Thread.currentThread().getName() + " End.");
    }

    private void task() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
