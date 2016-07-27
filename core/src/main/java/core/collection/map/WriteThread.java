package core.collection.map;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by ehimnay on 19/07/2016.
 */
public class WriteThread extends Thread {
    Map<String, String> map;

    public WriteThread(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        System.out.println("WriteThread started");
        try {
            TimeUnit.SECONDS.sleep(5);
            map.put("ALPHA", "ALPHA");
            map.put("BETA", "BETA");
        } catch (InterruptedException intException) {
            intException.printStackTrace();
        }
    }
}
