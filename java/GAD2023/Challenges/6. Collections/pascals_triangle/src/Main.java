import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> triangle = generatePascalTriangle(numRows);
        printPascalTriangle(triangle);
    }

    private static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows <= 0) {
            return triangle;
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int num = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    row.add(num);
                }
            }
            triangle.add(row);
        }

        return triangle;
    }

    private static void printPascalTriangle(List<List<Integer>> triangle) {
        for (List<Integer> row : triangle) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
