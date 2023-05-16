import java.util.Arrays;

public class MergeSort implements SortingStrategy {
    public void sort(Integer[] arr) {
        if (arr.length > 1) {
            int middle = arr.length / 2;
            Integer[] left = Arrays.copyOfRange(arr, 0, middle);
            Integer[] right = Arrays.copyOfRange(arr, middle, arr.length);
            sort(left);
            sort(right);
            merge(arr, left, right);
        }
    }

    private void merge(Integer[] arr, Integer[] left, Integer[] right) {
        int pointerLeft = 0;
        int pointerRight = 0;
        int pointerArr = 0;

        while (pointerLeft < left.length && pointerRight < right.length) {
            if (left[pointerLeft] < right[pointerRight]) {
                arr[pointerArr++] = left[pointerLeft++];
            } else {
                arr[pointerArr++] = right[pointerRight++];
            }
        }

        // if there's anything in the left arr
        while (pointerLeft < left.length) {
            arr[pointerArr++] = left[pointerLeft++];
        }

        // if there's anything in the right arr
        while (pointerRight < right.length) {
            arr[pointerArr++] = right[pointerRight++];
        }
    }

}
