package charcounter;

import java.util.Map;

public class Facade {

    private CharCounter charCounter;
    private Formatter formatter;

    public Facade(CharCounter charCounter, Formatter formatter) {
        super();
        this.charCounter = charCounter;
        this.formatter = formatter;
    }
    
    public String charCounterUserInterface(String lineInput) {
        if(Cache.isPresent(lineInput)) {
            return formatter.formatCharCounting(lineInput, Cache.getCache(lineInput));
        } else {
        Map<Character, Integer> result = charCounter.charCounting(lineInput);
        Cache.put(lineInput, result);
        return formatter.formatCharCounting(lineInput, result);
        }
    }

}
