package core.assignment;

import java.io.File;
import java.util.*;

/**
 * Created by ehimnay on 04/09/2016.
 */
public class ReadFile {
    public static void main(String...args) {
        final File file = new File(ReadFile.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        System.out.println(10_000 > System.currentTimeMillis() - file.lastModified());
    }
}
