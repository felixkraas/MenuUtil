package de.germanspacebuild.util.menuutil.menufile;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MenuFile {

    private Path filePath;
    private ArrayList<String> lines;

    /**
     * Creates new MenuFiles instance
     *
     * @param filePath Path of text file
     */
    public MenuFile(Path filePath) {
        this.filePath = filePath;
    }

    /**
     * Reads text from files and stores each line as an entry in an {@link ArrayList}
     *
     * @return False if file could not be read and true if reading was successful
     */
    public boolean read() {
        try {
            BufferedReader reader = Files.newBufferedReader(filePath, Charset.forName("UTF-8"));
            lines = new ArrayList<>();
            while (reader.readLine() != null) {
                lines.add(reader.readLine());
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Returns lines of the text as new {@link ArrayList}
     *
     * @return Text as list
     */
    public ArrayList<String> getLines() {
        if (lines == null) {
            read();
        }
        return new ArrayList<String>(lines);
    }

}
