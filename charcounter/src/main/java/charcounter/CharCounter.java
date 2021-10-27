package charcounter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CharCounter {
    
    private static final String EMPTY = "";
    
    protected Map<Character, Integer> charCounting(String line) {
        if (line == null) { 
            throw new IllegalArgumentException();
        }
        if(Cache.cache.containsKey(line)) {
            return Cache.cache.get(line);
        }
        char[] symbols = line.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char symbol : symbols) {
            map.put(symbol, (int) Arrays.stream(line.split(EMPTY)).filter(s -> s.equals("" + symbol)).count());
        }
        Cache.cache.put(line, map);
        return Cache.cache.get(line);   
    }
}
