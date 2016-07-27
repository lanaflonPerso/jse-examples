package core.collection.map;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by ehimnay on 19/07/2016.
 */
public class ReadThread extends Thread {
    Map<String, String> map;

    public ReadThread(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        System.out.println("ReadThread started");
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(map.get(entry.getKey()));
                TimeUnit.SECONDS.sleep(10);
            }
        } catch (InterruptedException intException) {
            intException.printStackTrace();
        }
    }
}
