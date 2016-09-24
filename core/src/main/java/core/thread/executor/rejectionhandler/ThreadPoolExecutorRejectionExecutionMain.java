package core.thread.executor.rejectionhandler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * Thread Pool Executor with, ArrayBlockingQueue and RejectionHandler 
 * 
 */
public class ThreadPoolExecutorRejectionExecutionMain {

    public static void main(String...args) throws InterruptedException {
        // RejectedExecutionHandler implementation
        RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();

        // creating the ThreadPoolExecutor with arrayblockingqueue
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2), rejectionHandler);
        // start the monitoring thread
        UserThread2 monitor = new UserThread2(executorPool, 3);

        Thread monitorThread = new Thread(monitor);
        monitorThread.start();
        // submit work to the thread pool
        for (int i = 0; i < 10; i++) {
            executorPool.execute(new UserThread("cmd" + i));
        }

        Thread.sleep(30000);
        // shut down the pool
        executorPool.shutdown();
        // shut down the monitor thread
        Thread.sleep(5000);
        monitor.shutdown();

    }
}