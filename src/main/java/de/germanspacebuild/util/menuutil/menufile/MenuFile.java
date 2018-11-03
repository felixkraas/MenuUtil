package de.germanspacebuild.util.menuutil.menufile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MenuFile {

    private String filePath;
    private ArrayList<String> lines;

    /**
     * Creates new MenuFiles instance
     *
     * @param filePath Path of text file
     */
    public MenuFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Reads text from files and stores each line as an entry in an {@link ArrayList}
     *
     * @return False if file could not be read and true if reading was successful
     */
    public boolean read() {
        if (!filePath.endsWith(".txt")) {
            StringBuilder sb = new StringBuilder(filePath.toString());
            sb.append(".txt");
            filePath = sb.toString();
        }
        try {
            InputStream in = ClassLoader.getSystemResourceAsStream(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
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
