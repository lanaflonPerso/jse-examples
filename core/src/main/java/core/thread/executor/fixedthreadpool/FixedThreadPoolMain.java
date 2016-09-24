package core.thread.executor.fixedthreadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FixedThreadPoolMain {
    public static void main(String...args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        System.out.println("Maximum threads inside pool " + executor.getMaximumPoolSize());
        for (int i = 0; i < 10; i++) {
            Task task = new Task("Task " + i);
            executor.execute(task);
            System.out.println("Current Thread Pool Size : " + executor.getPoolSize());
        }
        executor.shutdown();
    }
}