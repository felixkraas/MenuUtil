package de.germanspacebuild.util.menuutil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Felix on 13.03.2018
 * for MenuUtil
 * <p>
 * Contains utility for creating and working with Screens.
 * @author Felix
 */
public class ScreenUtil {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Reads text from TXT file for use in menu.
     * @param fileName Name of the file to be loaded. Should but must not end with .txt.
     * @return Text read from the file.
     */
    public static String readTextFile(String fileName) {
        String text = "";
        String line;

        if (!fileName.endsWith(".txt")) {
            StringBuilder sb = new StringBuilder(fileName);
            sb.append(".txt");
            fileName = sb.toString();
        }

        InputStream in = ClassLoader.getSystemResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        try {
            while ((line = reader.readLine()) != null) {
                StringBuilder sbText = new StringBuilder(text);
                sbText.append(line);
                sbText.append(System.lineSeparator());
                text = sbText.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return text;
    }

    /**
     * Scans screen for tags to be replaced with text.
     * @param screen Screen to be scanned.
     */
    public static void scanReplacementTags(Screen screen) {
        final String text = screen.getText();
        List<String> words = Arrays.asList(text.split("(\\r?\\n)"));
        for (String word : words) {
            if (word.startsWith("%")) {
                if (word.contains("File")) {
                    String[] file = word.split("([_])");
                    screen.addReplaceTag(word);
                    screen.editRaplaceTag(word, ScreenUtil.readTextFile(file[file.length - 1]));
                    continue;
                }
                screen.addReplaceTag(word);
            }
        }
    }

    /**
     * Reads input made by user.
     * @return Input the user made.
     */
    public static String readInput() {
        String s = scanner.nextLine();
        if (s == null || s.isEmpty()) {
            s = "";
        }
        resetInput();
        return s;
    }

    /**
     * Resets Scanner to System.in
     */
    private static void resetInput() {
        scanner = new Scanner(System.in);
    }

    /**
     * Clears the Screen completely.
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

}
