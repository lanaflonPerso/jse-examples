package core.thread.daemon;

class DaemonThread implements Runnable {

    private String msg;

    public DaemonThread(String msg){
        this.msg = msg;
    }
    @Override
    public void run() {
        while (true) {
            task();
        }
    }

    private void task() {
        try {
            System.out.println(msg);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}