package core.file;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadFile {

    public static void main(String...args) {
        File file = new File("C:/firmware/postfix.txt");
        /*
         * readBufferedReaderFileReader(file); readFileReader(file); readFileStream(file);
         * readFileStreamBufferedInputStream(file); readFileBufferedReaderInputStream(file);
         * 
         */
        readFileScaner("C:/firmware/postfix.txt");

    }

    public static void readBufferedReaderFileReader(File file) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void readFileReader(File file) {
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            Integer character;
            while ((character = fr.read()) != -1) {
                System.out.println(Character.toChars(character));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void readFileStream(File file) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            Integer character = null;
            while ((character = fis.read()) != -1) {
                System.out.println(Character.toChars(character));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void readFileBufferedReaderInputStream(File file) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void readFileScaner(String filePath) {
        Path path = Paths.get("");
        try {
            Scanner scanner = new Scanner(path);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * public static void readFileStreamBufferedInputStream(File file) { BufferedInputStream bis = null; try { bis = new
     * BufferedInputStream(new FileInputStream(file)); byte[] bytes = new byte[1024]; Integer EOF = 0; while ((EOF =
     * bis.read(bytes)) != -1) { System.out.println(EOF.toString()); } } catch (IOException exception) {
     * exception.printStackTrace(); } finally { if (bis != null) { try { bis.close(); } catch (IOException exception) {
     * exception.printStackTrace(); } } } }
     */
}
