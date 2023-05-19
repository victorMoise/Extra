import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(16);
        numbers.add(17);
        numbers.add(4);
        numbers.add(3);
        numbers.add(5);
        numbers.add(2);

        List<Integer> leaders = findLeaders(numbers);

        System.out.println("Leaders: " + leaders);
    }

    private static List<Integer> findLeaders(List<Integer> numbers) {
        List<Integer> leaders = new ArrayList<>();

        if (numbers.isEmpty()) {
            return leaders;
        }

        int maxRight = numbers.get(numbers.size() - 1);
        leaders.add(maxRight);

        for (int i = numbers.size() - 2; i >= 0; i--) {
            int current = numbers.get(i);
            if (current > maxRight) {
                leaders.add(current);
                maxRight = current;
            }
        }

        return leaders;
    }
}
