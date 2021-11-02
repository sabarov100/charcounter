package charcounter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Formatter {
    
    private static final String EMPTY = "";
    private static final String QUOTATION_MARK = "\"";
    private static final String EQUAL_SING = " = ";
    private static final String NEW_LINE = "\n";
    private static final String EXCEPTION_MESSAGE = "Argument cannot be NULL";
    
    public String formatCharCounting(String lineInput, Map<Character, Integer> mapInput) {
        if (lineInput == null || mapInput == null) { 
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        } 
        StringBuilder sb = new StringBuilder();
        Stream<String> streamOfArray = Arrays.stream(lineInput.split(EMPTY));
        List<String> list = streamOfArray.map(s->s.split(EMPTY)).flatMap(Arrays::stream)
            .distinct().collect(Collectors.toList());        
        for(String letter : list) {
            sb.append(QUOTATION_MARK).append(letter).append(QUOTATION_MARK)
                .append(EQUAL_SING).append(mapInput.get(letter.charAt(0))).append(NEW_LINE);   
        }
        return sb.toString();   
    }
}