package main.java.core.thread.lock.semaphore;

/**
 * Implements a counting semaphore implementation. This can be used as a mutex by initializing the count to one.
 */
public class BinarySemaphore {
    private int count;
    private int waitCount = 0;

    public BinarySemaphore(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(
                    String.format("BinarySemaphore count should be greater than zero. You passed: %d.", count));
        }

        this.count = count;
    }

    // Simple tests for the above class.
    public static void main(String...argsargs) {
        final BinarySemaphore semaphore = new BinarySemaphore(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                semaphore.acquire();
                try {
                    System.out.println("Acquired semaphore.. sleeping!");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphore.release();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                semaphore.acquire();
                try {
                    System.out.println("Acquired semaphore.. sleeping!");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphore.release();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                semaphore.acquire();
                try {
                    System.out.println("Acquired semaphore.. sleeping!");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphore.release();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                semaphore.acquire();
                try {
                    System.out.println("Acquired semaphore.. sleeping!");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphore.release();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                semaphore.acquire();
                try {
                    System.out.println("Acquired semaphore.. sleeping!");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphore.release();
            }
        }).start();
    }

    public synchronized void acquire() {
        waitCount++;
        while (count == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        waitCount--;
        count--;
    }

    public synchronized void release() {
        if (count == 0) {
            notify();
        }

        count++;
    }

    public synchronized int numWaitingThreads() {
        return waitCount;
    }
}
