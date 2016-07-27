package core.thread.daemon;

class DaemonThread implements Runnable {

    @Override
    public void run() {
        while (true) {
            task();
        }
    }

    private void task() {
        try {
            System.out.println("My life dependes on User Thread's");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}