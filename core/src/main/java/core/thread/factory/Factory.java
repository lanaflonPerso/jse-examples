package core.thread.factory;

import java.util.concurrent.ThreadFactory;

public class Factory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }

}
