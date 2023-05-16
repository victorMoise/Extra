import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 4, 5, 2, 3, 6, 9, 8, 7};
        Integer[] copy1 = Arrays.copyOf(arr, arr.length);
        Integer[] copy2 = Arrays.copyOf(arr, arr.length);

        AscBubbleSort ascending = new AscBubbleSort();
        ascending.sort(copy1);
        DescBubbleSort descending = new DescBubbleSort();
        descending.sort(copy2);

        displayArr(copy1);
        displayArr(copy2);
    }

    public static void displayArr(Integer[] arr) {
        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}