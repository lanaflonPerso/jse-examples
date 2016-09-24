package core.thread.futuretask;

import java.util.concurrent.*;

public class FutureTaskMain {

    public static void main(String...args) {

        ThreadCallable callable1 = new ThreadCallable(1000);
        ThreadCallable callable2 = new ThreadCallable(2000);

        FutureTask<String> futureTask1 = new FutureTask<String>(callable1);
        FutureTask<String> futureTask2 = new FutureTask<String>(callable2);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(futureTask1);
        executor.execute(futureTask2);

        while (true) {
            try {
                if (futureTask1.isDone() && futureTask2.isDone()) {
                    System.out.println("Done");
                    executor.shutdown();
                    return;
                }

                if (!futureTask1.isDone()) {
                    System.out.println("FutureTask1 output=" + futureTask1.get());
                }

                System.out.println("Waiting for FutureTask2 to complete");
                String s = futureTask2.get(200L, TimeUnit.MILLISECONDS);
                if (s != null) {
                    System.out.println("FutureTask2 output=" + s);
                }
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            } catch (ExecutionException exception) {
                exception.printStackTrace();
            } catch (TimeoutException exception) {
                exception.printStackTrace();
            }
        }
    }

}