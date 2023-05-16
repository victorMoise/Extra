package visitor;

public class Song implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Integer getMinutes() {
        return 20;
    }
}
