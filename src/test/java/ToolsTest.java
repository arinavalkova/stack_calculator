import org.junit.Test;

import static org.junit.Assert.*;

public class ToolsTest
{
    @Test
    public void findNameOfClass()
    {
        String test1 = "DEFINE";
        String test2 = "PUSH";
        String test3 = "POP";
        String test4 = "+";
        String test5 = "-";
        String test6 = "/";
        String test7 = "*";
        String test8 = "PRINT";
        String test9 = "SQRT";
        String test10 = "wrongCommand";

        assertEquals(Tools.findNameOfClass(test1), "Define");
        assertEquals(Tools.findNameOfClass(test2), "Push");
        assertEquals(Tools.findNameOfClass(test3), "Pop");
        assertEquals(Tools.findNameOfClass(test4), "Addition");
        assertEquals(Tools.findNameOfClass(test5), "Subtraction");
        assertEquals(Tools.findNameOfClass(test6), "Division");
        assertEquals(Tools.findNameOfClass(test7), "Multiplication");
        assertEquals(Tools.findNameOfClass(test8), "Print");
        assertEquals(Tools.findNameOfClass(test9), "Sqrt");
        assertNull(Tools.findNameOfClass(test10));
    }

    @Test
    public void isNumeric()
    {
        String test1 = "parameter";
        String test2 = "45";
        String test3 = "45.0";
        String test4 = "45,0";

        assertFalse(Tools.isNumeric(test1));
        assertTrue(Tools.isNumeric(test2));
        assertTrue(Tools.isNumeric(test3));
        assertTrue(Tools.isNumeric(test4));
    }
}