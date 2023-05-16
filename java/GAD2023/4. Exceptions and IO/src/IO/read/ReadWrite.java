package IO.read;

import java.io.*;
import java.util.Scanner;


public class ReadWrite {
    public void readText() {
        try {
            FileInputStream fs = new FileInputStream("./src/IO/read/in.txt");
            FileOutputStream fo = new FileOutputStream("./src/IO/read/out.txt");

            int c;
            while ((c = fs.read()) != -1) {
                fo.write(c);
                System.out.println(c);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }


    public void readWord() {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("./src/IO/read/in.txt"));
            String line;
            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }


    public void scanText() {
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader("./src/IO/read/in.txt")));
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.println(scanner.nextInt());
                }
                else scanner.next();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ReadWrite read = new ReadWrite();
//        read.readText();
        read.scanText();
    }
}
