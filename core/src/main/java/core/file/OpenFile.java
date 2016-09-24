package core.file;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class OpenFile {
    public static void main(String...args) {
        File file = new File("C:/Central Module/CAMT-2014_V2.pptx");
        if (Desktop.isDesktopSupported()) {
            if (file.exists()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.open(file);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}
