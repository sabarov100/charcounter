package charcounter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class FormatterTest {
    private static final String ACTUAL = "Hello world!";
    private static final String ACTUAL_NULL = null;
    private static final String EXPECTED_EXCEPTION_MESSAGE = "Argument cannot be NULL";
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
    void testFormatCharCounting() {
        assertEquals(EXPECTED, setUp().formatCharCounting(ACTUAL, instanse().charCounting(ACTUAL)));
    }
    
    @Test
    void testThrowsIllegalArgumentExceptionFormatCharCounting() {
        assertThrows(IllegalArgumentException.class, () -> setUp().formatCharCounting(ACTUAL_NULL, instanse().charCounting(ACTUAL_NULL)));
    } 

    void testMessageIllegalArgumentExceptionFormatCharCounting() {
        try {
            setUp().formatCharCounting(ACTUAL_NULL, instanse().charCounting(ACTUAL_NULL));
        }
        catch(IllegalArgumentException exception) {
            assertEquals(EXPECTED_EXCEPTION_MESSAGE, exception.getMessage());
        }
    }
}
