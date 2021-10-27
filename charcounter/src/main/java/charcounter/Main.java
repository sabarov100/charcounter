package charcounter;

public class Main {

    public static void main(String[] args) {
        Facade facade = new Facade();
        System.out.println(facade.charCounterUserInterface("Hello world!"));
    }
    
}
