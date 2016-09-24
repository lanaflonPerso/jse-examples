package core.file;

import java.io.*;

public class WriteFile {

    public static void main(String...args) {
        File file = new File("C:/Mercury/TestWorkspace/Core/Temp.txt");
        /*
         * writeFileFileWriter(file); writeFileFileOutputStream(file);
         */
        writeFileFileOutputStreamBufferedOutputStream(file);
    }

    public static void writeFileFileWriter(File file) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            fw.write("Himansu Nayak - FileWriter");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void writeFileFileOutputStream(File file) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(new String("Himansu Nayak - FileOutputStream").getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFileFileOutputStreamBufferedOutputStream(File file) {
        try {
            BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(file));
            fos.write(new String("Himansu Nayak - BufferedOutputStream").getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
