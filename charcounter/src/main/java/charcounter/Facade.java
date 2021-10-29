package charcounter;

public class Facade {
    
    public Facade(CharCounter charCounter, Formatter formatter) {
        super();
        this.charCounter = charCounter;
        this.formatter = formatter;
    }

    private CharCounter charCounter;
    private Formatter formatter;
    
    public String charCounterUserInterface(String lineInput) {
        return formatter.formatCharCounting(lineInput, charCounter.charCounting(lineInput));
    }

}
