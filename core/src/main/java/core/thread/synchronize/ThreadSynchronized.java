package core.thread.synchronize;

class SynchronizedThread implements Runnable {

    private Object lock = new Object();
    private String[] message = null;

    public SynchronizedThread(String...argsmessage) {
        this.message = message;
    }

    public String[] getMessage() {
        return message;
    }

    @Override
    public void run() {
        task(Thread.currentThread().getName());
    }

    private void task(String name) {
        for (int index = 0; index < message.length; index++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                System.out.println(name);
                System.out.println(message[index]);
            }
        }
    }

}