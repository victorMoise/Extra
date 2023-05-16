package visitor;

public class PriceVisitor implements Visitor {
    private int price;

    public int getPrice() {
        return this.price;
    }

    @Override
    public void visit(Book book) {
        price += book.getPages() * 0.5;
    }

    @Override
    public void visit(Song song) {
        price += song.getMinutes();
    }

    @Override
    public void visit(Film film) {
        price += film.getMinutes() * 2;
    }
}
