package core.java7;

import java.io.*;

public class AutomaticResourceManagement {

    public static void main(String...args) throws FileNotFoundException {
        Reader reader = new FileReader("c:/temp.txt") {
            @Override
            public void close() {
                System.out.println("inside file reader close()");
            }

        };

        try (BufferedReader br = new BufferedReader(reader)) {
            String readLine;
            while ((readLine = br.readLine()) != null) {
                System.out.println(readLine);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}