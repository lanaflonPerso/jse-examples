package core.thread.threadlocal;

import java.util.Date;

/*
 * http://stackoverflow.com/questions/1202444/how-is-javas-threadlocal-implemented-under-the-hood
 * http://java.dzone.com/articles/how-threadlocal-implemented
 */
public class ThreadLocalThread implements Runnable {

    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println("Thread: " + Thread.currentThread().getName() + " Formatted Date: "
                    + ThreadLocalMain.threadSafeFormat(new Date()));
        }
    }

}