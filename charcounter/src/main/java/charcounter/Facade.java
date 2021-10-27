package charcounter;

public class Facade {
    
    private CharCounter charCounter;
    private Formatter formatter;
    
    public String charCounterUserInterface(String lineInput) {
        charCounter = new CharCounter();
        formatter = new Formatter();
        return formatter.formatCharCounting(lineInput, charCounter.charCounting(lineInput));
    }

}
