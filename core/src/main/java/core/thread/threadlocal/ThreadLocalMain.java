package core.thread.threadlocal;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class ThreadLocalMain {

    public static void main(String...args) throws IOException {
        Thread t1 = new Thread(new ThreadLocalThread());
        Thread t2 = new Thread(new ThreadLocalThread());

        t1.start();
        t2.start();

    }

    public static String threadSafeFormat(Date date) {
        DateFormat formatter = DateFormatter.getDateFormatter();
        return formatter.format(date);
    }

}
