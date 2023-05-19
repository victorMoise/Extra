import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> triangle = generateBellsTriangle(numRows);
        printBellsTriangle(triangle);
    }

    private static List<List<Integer>> generateBellsTriangle(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows <= 0) {
            return triangle;
        }

        // Initialize the first row with 1
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> previousRow = triangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();

            // Calculate the values for the current row
            currentRow.add(previousRow.get(previousRow.size() - 1));
            for (int j = 1; j <= i; j++) {
                int value = currentRow.get(j - 1) + previousRow.get(j - 1);
                currentRow.add(value);
            }

            triangle.add(currentRow);
        }

        return triangle;
    }

    private static void printBellsTriangle(List<List<Integer>> triangle) {
        for (List<Integer> row : triangle) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
