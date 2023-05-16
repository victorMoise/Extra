package visitor;

public class TimeVisitor implements Visitor {
    private int time;

    public int getTime() {
        return time;
    }

    @Override
    public void visit(Book book) {
        this.time += book.getPages() * 5;
    }

    @Override
    public void visit(Song song) {
        this.time += song.getMinutes();
    }

    @Override
    public void visit(Film film) {
        this.time += film.getMinutes() + 10;
    }
}
