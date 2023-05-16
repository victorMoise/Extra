import java.util.Arrays;

public class Main {

    public static void displaySorted(SortingStrategy strategy, Integer[] arr) {
        strategy.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1, 4, 5, 2, 3, 6, 9, 8, 7};
        Integer[] copy1 = Arrays.copyOf(arr, arr.length);
        Integer[] copy2 = Arrays.copyOf(arr, arr.length);

        displaySorted(new BubbleSort(), copy1);
        displaySorted(new MergeSort(), copy2);
    }
}