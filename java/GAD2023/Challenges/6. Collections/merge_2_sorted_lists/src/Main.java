import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 3, 5, 7, 9);
        List<Integer> list2 = List.of(2, 4, 6, 8, 10);

        List<Integer> mergedList = mergeSortedLists(list1, list2);

        System.out.println("Merged List: " + mergedList);
    }

    private static List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();

        int i = 0; // Index for list1
        int j = 0; // Index for list2

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        // Add the remaining elements from list1, if any
        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        // Add the remaining elements from list2, if any
        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }
}
