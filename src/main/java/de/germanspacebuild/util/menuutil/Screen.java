package de.germanspacebuild.util.menuutil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Felix on 13.03.2018
 * for MenuUtil
 *
 * @author Felix
 */
public class Screen {

    protected String input = "";
    private final String text;
    private Map<String, String> replaceTags = new HashMap<>();
    private boolean awaitsInput = false;

    /**
     * Creates new screen.
     * @param text Text of the screen.
     */
    public Screen(String text) {
        this.text = text;
    }

    /**
     * Prints text to screen and replaces all tags with it's designated text.
     */
    public void print() {
        String screen = text;
        for (String key : replaceTags.keySet()) {
            screen = screen.replaceAll(key, replaceTags.get(key));
        }
        System.out.println(screen);
        if (awaitsInput) {
            this.input = ScreenUtil.readInput();
        }
    }

    /**
     * Closes screen and clears input and tags.
     */
    public void close() {
        replaceTags.clear();
        input = "";
    }

    /**
     * Gets text of screen.
     * @return Text of screen.
     */
    public String getText() {
        return text;
    }

    /**
     * Edit a tags replacement text.
     * @param tag Tag to edit.
     * @param replacement Replacement for the tag.
     */
    public void editRaplaceTag(String tag, String replacement) {
        replaceTags.put(tag, replacement);
    }

    /**
     * Adds a new tag to the Screen.
     * @param tag Tag to be added.
     */
    public void addReplaceTag(String tag) {
        replaceTags.put(tag, "@WARNING_NO_REPLACEMENT@ " + tag);
    }

    /**
     * Gets all tags and there replacement.
     * @return All tags and there replacement.
     */
    public Map<String, String> getReplaceTags() {
        return replaceTags;
    }

    /**
     * Get current input for the screen.
     * @return Current input.
     */
    public String getInput() {
        return input;
    }

    /**
     * Set the screen to await input from user.
     * @param awaitsInput Whether or not the screen awaits input from the user.
     */
    public void setAwaitsInput(boolean awaitsInput) {
        this.awaitsInput = awaitsInput;
    }
}
