package de.germanspacebuild.util.menuutil;

import org.junit.Assert;
import org.junit.Test;

public class ScreenUtilTest {

    @Test
    public void readTextFile() {
        Assert.assertEquals("This is a Test. Lorem Ipsum." + System.lineSeparator(), ScreenUtil.readTextFile("readFileTest.txt"));
    }

    @Test
    public void readTextFileNoFileEnding() {
        Assert.assertEquals("This is a Test. Lorem Ipsum." + System.lineSeparator(), ScreenUtil.readTextFile("readFileTest"));
    }

}