package exception;

public class Main {
    public static int test() {
        try {
            throw new RuntimeException();
        }
        catch(Exception e) {
            System.out.println("catch");
            return 1;
        }
        finally {
            System.out.println("finally");
            return 2;
        }
    }

    public static void main(String[] args) throws NumberNotEvenException {
        Calculator calc = new Calculator();
        int i = 5;
        try {
            calc.calculate(i);
        }
        catch(NumberNotEvenException e) {
            calc.calculate(i * 2);
        }
    }

}
