package charcounter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CharCounter {
    
    private static final String EMPTY = "";
    
    public Map<Character, Integer> charCounting(String line) {
        if (line == null) { 
            throw new IllegalArgumentException();
        }
        if(Cache.cache.containsKey(line)) {
            return Cache.cache.get(line);
        }
        char[] symbols = line.toCharArray();
        Map<Character, Integer> resultMap = new HashMap<>();
        for(char symbol : symbols) {
            resultMap.put(symbol, (int) Arrays.stream(line.split(EMPTY)).filter(s -> s.equals(symbol)).count());
        }
        Cache.cache.put(line, resultMap);
        return resultMap;   
    }
}
