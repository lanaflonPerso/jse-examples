package core.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileMain {
    public static void main(String...args) {
        File file = new File("C:/firmware/postfix.txt");
        readFileRandomly(file);
    }

    public static void readFileRandomly(File file) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(file, "r");
            raf.seek(5);
            int character = 0;
            while ((character = raf.read()) != -1) {
                System.out.println((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
