package core.thread.shutdownhook;

class UserThread implements Runnable {

    @Override
    public void run() {
        task();
    }

    private void task() {
        try {
            System.out.println(Thread.currentThread().getName() + " execution");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}