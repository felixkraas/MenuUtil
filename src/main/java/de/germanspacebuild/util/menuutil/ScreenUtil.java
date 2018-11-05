package de.germanspacebuild.util.menuutil;

import java.util.Scanner;

/**
 * Created by Felix on 13.03.2018
 * for MenuUtil
 * <p>
 * Contains utility for creating and working with Screens.
 *
 * @author Felix
 */
public class ScreenUtil {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Reads input made by user.
     *
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
