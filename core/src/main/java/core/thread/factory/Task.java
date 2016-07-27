package core.thread.factory;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println("Inside : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
