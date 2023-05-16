package visitor;

public class Book implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Integer getPages() {
        return 200;
    }
}
