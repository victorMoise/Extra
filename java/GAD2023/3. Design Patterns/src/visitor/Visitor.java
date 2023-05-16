package visitor;

public interface Visitor {
    public void visit(Book book);
    public void visit(Song song);
    public void visit(Film film);
}
