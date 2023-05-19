import java.util.Arrays;
import java.util.List;

public class Main {
    private static List<String> words = Arrays.asList(
            "the",
            "quick",
            "brown",
            "fox",
            "jumped",
            "over",
            "the",
            "lazy",
            "dog"
    );

    // Display the letters from the words list and count them
    // 1. t
    // 2. h
    // 3. e
    static void displayingLetters() {
        int count = 1;
        for (String word : words) {
            for (char letter : word.toCharArray()) {
                System.out.println(count + ". " + letter);
                count++;
            }
        }
    }

    // Find the missing letter from the words list
    // Use the same way as displayingLetters to display the result
    static void findingMissingLetter() {
        int count = 1;
        for (String word : words) {
            for (char letter : word.toCharArray()) {
                System.out.println(count + ". " + letter);
                count++;
            }
        }
        System.out.println(count + ". [Missing Letter]");
    }

    // Restore the missing letter from the words list
    // Use the same way as displayingLetters to display the result
    static void restoringMissingLetter() {
        int count = 1;
        for (String word : words) {
            for (char letter : word.toCharArray()) {
                System.out.println(count + ". " + letter);
                count++;
            }
        }
        System.out.println(count + ". [Restored Letter]");
    }

    public static void main(String[] args) {
        displayingLetters();
        findingMissingLetter();
        restoringMissingLetter();
    }
}
