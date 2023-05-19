import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String input = "listen";
        List<String> anagrams = generateAnagrams(input);

        try (FileWriter writer = new FileWriter("output.txt")) {
            for (String anagram : anagrams) {
                writer.write(anagram + "\n");
            }
            System.out.println("Anagrams have been written to output.txt successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }

    private static List<String> generateAnagrams(String input) {
        List<String> anagrams = new ArrayList<>();
        generate("", input, anagrams);
        return anagrams;
    }

    private static void generate(String prefix, String remaining, List<String> anagrams) {
        int length = remaining.length();

        if (length == 0) {
            anagrams.add(prefix);
        } else {
            for (int i = 0; i < length; i++) {
                char current = remaining.charAt(i);
                String newPrefix = prefix + current;
                String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
                generate(newPrefix, newRemaining, anagrams);
            }
        }
    }
}
