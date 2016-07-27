package core.thread.futuretask;

import java.util.concurrent.Callable;

public class ThreadCallable implements Callable<String> {

    private long waitTime;

    public ThreadCallable(int timeInMillis) {
        this.waitTime = timeInMillis;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(waitTime);
        return Thread.currentThread().getName();
    }

}