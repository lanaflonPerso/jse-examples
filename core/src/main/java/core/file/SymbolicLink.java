package core.file;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by ehimnay on 1/29/2016.
 */
public class SymbolicLink {
    public static void main(String...args) throws java.io.IOException {
        Path existingFilePath = Paths.get("C:\\Java_Dev\\test1.txt");
        Path symLinkPath = Paths.get("C:\\test1_link.txt");
        Files.createSymbolicLink(symLinkPath, existingFilePath);
    }
}
