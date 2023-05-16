package exception;

public class Calculator {
    public void calculate(int i) throws NumberNotEvenException {
        if (i > 0) {
            if (i % 2 != 0) {
                throw new NumberNotEvenException();
            }
            respond();
        }
        else {
            throw new FatalException();
        }
    }

    public void respond() {
        System.out.println("response");
    }
}
