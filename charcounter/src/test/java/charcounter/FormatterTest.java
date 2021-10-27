package charcounter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class FormatterTest {
    private static final String ACTUAL = "Hello world!";
    private static final String EXPECTED = ""
            + "\"H\" = 1\n"
            + "\"e\" = 1\n"
            + "\"l\" = 3\n"
            + "\"o\" = 2\n"
            + "\" \" = 1\n"
            + "\"w\" = 1\n"
            + "\"r\" = 1\n"
            + "\"d\" = 1\n"
            + "\"!\" = 1\n";

    @Before
    private Formatter setUp(){
        return new Formatter();
    }
    
    @Before
    private CharCounter instanse(){
        return new CharCounter();
    }

    @Test
    void testCharCounting() {
        assertEquals(EXPECTED, setUp().formatCharCounting(ACTUAL, instanse().charCounting(ACTUAL)));
    }
    
    @Test
    void testThrowsIllegalArgumentExceptionCharCounting() {
        String str = null;
        assertThrows(IllegalArgumentException.class, () -> setUp().formatCharCounting(str, instanse().charCounting(str)));
    } 

}
