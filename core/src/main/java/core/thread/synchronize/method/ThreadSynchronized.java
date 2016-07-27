package core.thread.synchronize.method;

class SynchronizedThread implements Runnable {

    private Message message;

    public SynchronizedThread(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        task(Thread.currentThread().getName());
    }

    private void task(String name) {
        try {
            synchronized (this) {
                for (int i = 0; i < 5; i++) {
                    message.printMessage();
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void print() {
        System.out.println("Inside Print Method");
    }

}