package de.germanspacebuild.util.menuutil.menufile;

import java.nio.file.Path;
import java.util.ArrayList;

public class FileParser {

    private MenuFile menuFile;

    public FileParser(Path menuFilePath) {
        this.menuFile = new MenuFile(menuFilePath);
    }

    public FileParser(MenuFile menuFile) {
        this.menuFile = menuFile;
    }

    public boolean parse() {
        ArrayList<String> lines = menuFile.getLines();
        removeCommends(lines);

        return false;
    }

    private void removeCommends(ArrayList<String> lines) {
        for (String line : lines) {
            if (line.startsWith("#")) {
                lines.remove(line);
            }
        }
    }


}
