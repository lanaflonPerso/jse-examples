package core.scratch;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FileTime {
    public static void main(String[] args) throws InterruptedException {
        File file = new File("C://temp//a.txt");
        int a = -1;
        System.out.println(-a);
        int sec = 0;
       while(diff(file) <= 10_000){
            TimeUnit.SECONDS.sleep(1);
            System.out.println(++sec);
        }
    }

    public static long diff(final File file){
        long lastModifiedTime = file.lastModified();
        long currentTime = System.currentTimeMillis();
        long diff = currentTime - lastModifiedTime;
        System.out.println(lastModifiedTime);
        System.out.println(currentTime);
        System.out.println(diff);
        return diff;
    }
}
