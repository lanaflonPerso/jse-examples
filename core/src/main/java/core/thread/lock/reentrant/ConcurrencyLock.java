package core.thread.lock.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyLock implements Runnable {

    private static Lock lock;
    private Resource resource;

    public ConcurrencyLock(Resource resource) {
        this.resource = resource;
        this.lock = new ReentrantLock();
    }

    @Override
    public void run() {
        try {
            try {
                if (lock.tryLock(10, TimeUnit.SECONDS)) {
                    System.out.println("Thread : " + Thread.currentThread().getName());
                    resource.task();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
            System.out.println("Lock Release by Thread : " + Thread.currentThread().getName());
        }
    }

}