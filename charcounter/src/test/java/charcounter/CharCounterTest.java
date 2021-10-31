package charcounter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class CharCounterTest {
    
    private static final String ACTUAL = "Hello world!";
    private static final String ACTUAL_NULL = null;
    private static final String EXPECTED_EXCEPTION_MESSAGE = "Line cannot be NULL";
    private static Map<Character, Integer> EXPECTED;
    static {
        EXPECTED = new HashMap<Character, Integer>();
        EXPECTED.put('H', 1);
        EXPECTED.put('e', 1);
        EXPECTED.put('l', 3);
        EXPECTED.put('o', 2);
        EXPECTED.put(' ', 1);
        EXPECTED.put('w', 1);
        EXPECTED.put('r', 1);
        EXPECTED.put('d', 1);
        EXPECTED.put('!', 1);
    }
    
   

    @Before
    private CharCounter setUp(){
        return new CharCounter();
    }

    @Test
    void testCharCounting() {
        assertEquals(EXPECTED, setUp().charCounting(ACTUAL));
    }
    
    @Test
    void testThrowsIllegalArgumentExceptionCharCounting() {
        assertThrows(IllegalArgumentException.class, () -> setUp().charCounting(ACTUAL_NULL));
    }
    
    @Test
    void testMessageIllegalArgumentExceptionCharCounting() {
        try {
            setUp().charCounting(ACTUAL_NULL).toString();
        }
        catch(IllegalArgumentException exception) {
            assertEquals(EXPECTED_EXCEPTION_MESSAGE, exception.getMessage());
        }
    }

}
