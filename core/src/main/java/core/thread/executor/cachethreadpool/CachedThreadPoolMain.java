package core.thread.executor.cachethreadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CachedThreadPoolMain {
    public static void main(String...args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        System.out.println("Cached Thread Pool Size : " + executor.getCorePoolSize());
        for (int i = 0; i <= 5; i++) {
            Task task = new Task("Task " + i);
            executor.execute(task);
            System.out.println("Current Thread Pool Size : " + executor.getPoolSize());
        }
        executor.shutdown();
    }
}