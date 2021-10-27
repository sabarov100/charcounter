package charcounter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class CharCounterTest {
    
    private static final String ACTUAL = "Hello world!";
    private static final String EXPECTED = "{ =1, !=1, r=1, d=1, e=1, w=1, H=1, l=3, o=2}";

    @Before
    private CharCounter setUp(){
        return new CharCounter();
    }

    @Test
    void testCharCounting() {
        assertEquals(EXPECTED, setUp().charCounting(ACTUAL).toString());
    }
    
    @Test
    void testThrowsIllegalArgumentExceptionCharCounting() {
        String str = null;
        assertThrows(IllegalArgumentException.class, () -> setUp().charCounting(str));
    }

}
