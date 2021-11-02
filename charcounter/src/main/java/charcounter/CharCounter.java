package charcounter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CharCounter {
    
    private static final String EMPTY = "";
    private static final String EXCEPTION_MESSAGE = "Line cannot be NULL";
    
    protected Map<Character, Integer> charCounting(String line) {
        if (line == null) { 
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        char[] symbols = line.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char symbol : symbols) {
            map.put(symbol, (int) Arrays.stream(line.split(EMPTY)).filter(s -> s.equals("" + symbol)).count());
        }
        return map;   
    }
}
