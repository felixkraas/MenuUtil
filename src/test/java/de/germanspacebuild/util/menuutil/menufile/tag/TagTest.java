package de.germanspacebuild.util.menuutil.menufile.tag;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class TagTest {

    private Tag tag;

    @Test
    public void getTypeInvalid() {
        tag = new Tag("@ThisIsAnInvalidTag{ladiad, di ,da}");
        assertEquals(TagType.INVALID, tag.getType());
    }

    @Test
    public void getParameterAction() {
        tag = new Tag("@ACTION{1, This is a test, this_is_a_test_id}");
        assertEquals(Arrays.asList("1", "This is a test", "this_is_a_test_id"), tag.getParameter());
    }

    @Test
    public void getTypeAction() {
        tag = new Tag("@ACTION{1, This is a test, this_is_a_test_id}");
        assertEquals(TagType.ACTION, tag.getType());
    }

    @Test
    public void getParameterFile() {
        tag = new Tag("@FILE{test.txt}");
        assertEquals(Arrays.asList("test.txt"), tag.getParameter());
    }

    @Test
    public void getTypeFile() {
        tag = new Tag("@FILE{test.txt}");
        assertEquals(TagType.FILE, tag.getType());
    }

    @After
    public void tearDown() throws Exception {
        tag = null;
    }
}