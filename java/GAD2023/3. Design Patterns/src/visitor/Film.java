package visitor;

public class Film implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getMinutes() {
        return 40;
    }
}
