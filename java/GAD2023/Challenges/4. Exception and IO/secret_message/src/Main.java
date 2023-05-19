import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\extra\\java\\GAD2023\\Challenges\\4. Exception and IO\\secret message\\src\\input.txt";
        String secretMessage = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Remove non-capital letters and replace 'X' with space
                secretMessage += line.replaceAll("[^A-Z]", "").replace("X", " ");
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        System.out.println("Secret Message: " + secretMessage);
    }
}
