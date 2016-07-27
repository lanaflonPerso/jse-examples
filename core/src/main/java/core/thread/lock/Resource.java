package core.thread.lock;

import java.util.concurrent.TimeUnit;

public class Resource {
    public void task() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }
}
