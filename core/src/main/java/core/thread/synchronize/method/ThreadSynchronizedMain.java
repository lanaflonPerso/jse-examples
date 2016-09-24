package core.thread.synchronize.method;

public class ThreadSynchronizedMain {

    public static void main(String...args) throws InterruptedException {
        Message message = new Message("Himansu Nayak");
        SynchronizedThread threadSynchronized = new SynchronizedThread(message);
        Thread t1 = new Thread(threadSynchronized, "Thread Alpha");
        Thread t2 = new Thread(threadSynchronized, "Thread Beta");
        Thread t3 = new Thread(threadSynchronized, "Thread Gamma");

        // start all the threads
        /*t1.start();
        t2.start();
        t3.start();*/

        // wait for threads to finish
        t1.join();
        t2.join();
        t3.join();

    }

}