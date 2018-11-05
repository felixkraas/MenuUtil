package de.germanspacebuild.util.menuutil.menufile.tag;

import java.util.ArrayList;
import java.util.Arrays;


public class Tag {

    private TagType type;
    private ArrayList<String> parameter;

    /**
     * Creates new {@code Tag} from string.
     *
     * @param tagLine Line that contains the Tag
     */
    public Tag(String tagLine) {
        type = determineType(tagLine);
        parameter = parseParameter(tagLine);
    }

    /**
     * Determine the type of the {@code Tag}.
     *
     * @param tag Line that contains the tag
     * @return Type of the tag
     */
    private TagType determineType(String tag) {
        if (tag.startsWith("@FILE")) {
            return TagType.FILE;
        } else if (tag.startsWith("@ACTION")) {
            return TagType.ACTION;
        } else if (tag.startsWith("@INPUT")) {
            return TagType.INPUT;
        } else if (tag.startsWith("@ID")) {
            return TagType.ID;
        } else {
            return TagType.INVALID;
        }
    }

    /**
     * Parses all parameters from a given {@code Tag}.
     *
     * @param tag Line that contains the tag
     * @return List of all parameters in the tag
     */
    private ArrayList<String> parseParameter(String tag) {
        String[] params = tag.replaceAll("@[a-zA-Z]*\\{", "").replaceAll("[}]", "").split(", ");
        return new ArrayList<>(Arrays.asList(params));
    }

    /**
     * Returns the parameter at a given index.
     *
     * @param index Index of the parameter
     * @return Parameter at the given index.
     */
    public String getParameter(int index) {
        return parameter.get(index);
    }

    /**
     * Gets a List of all parameters as {@link String}.
     *
     * @return All parameters
     */
    public ArrayList<String> getParameter() {
        return parameter;
    }

    /**
     * Gets type of {@code Tag}.
     *
     * @return Type of the tag
     */
    public TagType getType() {
        return type;
    }
}
