import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        findNumbers();
    }

    public static void findNumbers() {
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader("C:\\extra\\Java\\Challanges\\4. Exception and IO\\phonebook\\src\\input.txt")));
            while (scanner.hasNext()) {
                String name = scanner.next();
                String phone = scanner.next();
                if (Objects.equals(name, "Abbey") || Objects.equals(name, "Abdul")) {
                    System.out.println(name + ": " + phone);
                }
            }
            scanner.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}