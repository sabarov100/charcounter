package charcounter;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    
    private static Map<String, Map> cache = new HashMap<>();
    
    public static void put(String line, Map<Character, Integer> charCounter) {
        cache.put(line, charCounter);
    }

    public static Map<Character, Integer> getCache(String line) {
        return cache.get(line);
    }

    public static boolean isPresent(String line) {
        return cache.containsKey(line);
    }
    
}
