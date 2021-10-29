package charcounter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)

class FacadeTest {
    
    private static final String INPUT_STRING = "Hello world!";
    private static final String OUTPUT_STRING = ""
            + "\"H\" = 1\n"
            + "\"e\" = 1\n"
            + "\"l\" = 3\n"
            + "\"o\" = 2\n"
            + "\" \" = 1\n"
            + "\"w\" = 1\n"
            + "\"r\" = 1\n"
            + "\"d\" = 1\n"
            + "\"!\" = 1\n";
    
    @Mock
    private CharCounter mockedCharCounter;
    
    @Mock
    private Formatter mockedFormatter;
    
    @InjectMocks
    private Facade facade;
    
    @Before
    private static Facade setUp() {
        return  new Facade(new CharCounter(), new Formatter());
    }
    
    @Test
    void testCharCounterUserInterface() {
        mockedCharCounter = Mockito.mock(CharCounter.class);
        mockedFormatter = Mockito.mock(Formatter.class);
        String checkingNull = mockedFormatter.formatCharCounting(INPUT_STRING, mockedCharCounter.charCounting(INPUT_STRING));
        String actual = setUp().charCounterUserInterface(INPUT_STRING);
        assertEquals(null, checkingNull);
        assertEquals(OUTPUT_STRING, actual);
        verify(mockedCharCounter).charCounting(INPUT_STRING);
        verify(mockedFormatter).formatCharCounting(INPUT_STRING, mockedCharCounter.charCounting(INPUT_STRING));
    }
    
    @Test
    void testTwrowsIllegalArgumentExceptionCharCounterUserInterface() {
        assertThrows(IllegalArgumentException.class, () -> setUp().charCounterUserInterface(null));
        
    }
}
