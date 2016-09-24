package core.file;

import java.io.File;

public class ListFile {
    private static int counter = 0;

    public static void main(String...args) {
        final String FOLDER_PATH = "C:/Central Module/JSF/CAMT Jars";
        recursiveSearch(new File(FOLDER_PATH));
        System.out.println("Total No Of Files : " + counter);
    }

    public static void recursiveSearch(File file) {
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File files[] = file.listFiles();
            for (File deletefile : files) {
                recursiveSearch(deletefile);
            }
        }
        if (file.isFile()) {
            System.out.println("File : " + file.getName());
            counter++;
        }
    }
}