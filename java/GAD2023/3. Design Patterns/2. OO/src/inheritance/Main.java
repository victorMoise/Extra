package inheritance;

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = new Parent();
        child.displayDescription();
        child.displaySecret();
        child.displaySecret2();
        parent.displaySecret();
    }
}
