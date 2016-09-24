package core.thread.callable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class CallableThreadMain {

    public static void main(String...args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Callable<String> callable = new CallableUserThread();

        // create future list for storing task
        List<Future<String>> list = new ArrayList<Future<String>>();

        for (int i = 0; i < 100; i++) {
            Future<String> future = executor.submit(callable);
            list.add(future);
        }
        for (Future<String> fut : list) {
            try {
                System.out.println(new Date() + "::" + fut.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        // shut down the executor service now
        executor.shutdown();
    }
}