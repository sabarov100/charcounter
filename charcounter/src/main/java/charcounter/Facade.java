package charcounter;

public class Facade {

    private CharCounter charCounter;
    private Formatter formatter;

    public Facade(CharCounter charCounter, Formatter formatter) {
        super();
        this.charCounter = charCounter;
        this.formatter = formatter;
    }
    
    public String charCounterUserInterface(String lineInput) {
        return formatter.formatCharCounting(lineInput, charCounter.charCounting(lineInput));
    }

}
