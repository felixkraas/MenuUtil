package de.germanspacebuild.util.menuutil.menufile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MenuFileTest {

    private MenuFile file;

    @Before
    public void setUp() throws Exception {
        file = new MenuFile("readFileTest.txt");
    }

    @Test
    public void read() {
        file.read();
        assertEquals(new ArrayList<>(Arrays.asList("This is a Test. Lorem Ipsum.")),
                file.getLines());
    }

    @Test
    public void readNoFileExtension() {
        file = new MenuFile("readFileTest");
        file.read();
        assertEquals(new ArrayList<>(Arrays.asList("This is a Test. Lorem Ipsum.")), file.getLines());
    }

    @Test
    public void getLines() {
        file.read();
        assertEquals("This is a Test. Lorem Ipsum.", file.getLines().get(0));
    }

    @After
    public void tearDown() throws Exception {
        file = null;
    }
}