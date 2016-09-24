package core.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Thread Pool Executor with 5 threads in the pool, 
 */
public class ThreadPoolEexcutorMain {

    public static void main(String...args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new UserThread("" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        // making the main thread to wait till all threads are finish execution
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }

}