public class Pair<T extends Shoe> {
    private T first;
    private T second;

    public Pair(T first, T second) {
        if (!first.getClass().equals(second.getClass())) {
            throw new TypesDoNotMatchException();
        }

        if (first.getSize() != second.getSize()) {
            throw new SizesDoNotMatchException();
        }

        if (!first.getColor().equals(second.getColor())) {
            throw new ColorsDoNotMatchException();
        }

        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
