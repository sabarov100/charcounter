package charcounter;

public class Main {

    public static void main(String[] args) {
        Facade facade = new Facade(new CharCounter(), new Formatter());
        System.out.println(facade.charCounterUserInterface("Hello world!"));
    }
    
}
