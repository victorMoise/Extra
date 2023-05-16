import java.util.NoSuchElementException;

public class ArrayCustomIterator {
    private int[] arr;
    private int currentIndex;

    public ArrayCustomIterator(int[] arr) {
        this.arr = arr;
        this.currentIndex = 0;
    }

    public boolean hasNext() {
        return this.currentIndex < this.arr.length;
    }

    public int next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        int value = arr[currentIndex];
        currentIndex += 1;
        return value;
    }
}
