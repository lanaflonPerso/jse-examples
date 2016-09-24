package com.org.puzzle;

import java.io.File;
import java.io.IOException;
import java.util.IdentityHashMap;

public class FileTest {
    public static void main(String...args) {
        try {
            IdentityHashMap<String, String> map = new IdentityHashMap<String, String>();
            map.put("Himansu", "Orissa");
            map.put(new String("Himansu"), "Bangalore");
            System.out.println(map);
            File file = new File("c:\\newfile.txt");

            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}