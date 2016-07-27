package core.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicThread implements Runnable {
    private AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Atomic Value : " + getCount());
        for (int i = 1; i <= 4; i++) {
            count.incrementAndGet();
            processSomething(i);
        }
    }

    public int getCount() {
        return this.count.get();
    }

    private void processSomething(int i) {
        // processing some job
        try {
            System.out.println(getCount());
            Thread.sleep(i * 1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}