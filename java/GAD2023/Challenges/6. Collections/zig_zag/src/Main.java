import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 3, 7, 8, 6, 2, 1);

        rearrange(numbers);

        System.out.println("Rearranged Numbers: " + numbers);
    }

    private static void rearrange(List<Integer> numbers) {
        Collections.sort(numbers);

        for (int i = 1; i < numbers.size() - 1; i += 2) {
            Collections.swap(numbers, i, i + 1);
        }
    }
}
