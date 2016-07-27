package core.thread.callable;

import java.util.concurrent.Callable;

public class CallableUserThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }

}
