package charcounter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharCounter {
    
    private static final String EMPTY = "";
    private static final char QUOTATION_MARK = (char)34;
    private static final String EQUAL_SING = " = ";
    private static final String NEW_LINE = "\n";
    private static Map<String, String> DATA_CHAR_COUNTING = new HashMap();
    
    public String charCounting(String line) {
        if (line == null) { 
            throw new IllegalArgumentException();
        }
        if(DATA_CHAR_COUNTING.containsKey(line)) return DATA_CHAR_COUNTING.get(line);
        String[] symbols = line.split(EMPTY);
        Stream<String> streamOfArray = Arrays.stream(symbols);
        List<String> list = streamOfArray.map(s->s.split(EMPTY)).flatMap(Arrays::stream)
                .distinct().collect(Collectors.toList());        
        StringBuilder sb = new StringBuilder();
        int value = 0;
        for(String symbol : list) {
            value = (int) Arrays.stream(symbols).filter(s -> s.equals(symbol)).count();
            sb.append(QUOTATION_MARK).append(symbol).append(QUOTATION_MARK).append(EQUAL_SING)
            .append(value).append(NEW_LINE);
        }
        DATA_CHAR_COUNTING.put(line, sb.toString());
        return sb.toString();   
    }
}
