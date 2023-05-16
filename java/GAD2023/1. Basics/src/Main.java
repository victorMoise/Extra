public class Main {
    static void copyExample() {
        char[] copyFrom = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' };
        char[] copyTo = new char[7];
        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
        System.out.println(copyTo);
    }

    static void compareString() {
        String firstString = new String("FirstString");
        String secondString = new String("SecondString");

        if (firstString.equals(secondString)) {
            System.out.println("true");
        }
    }

    public static void main(String[] args) {
        copyExample();
        byte a1 = 12;
        byte a2 = 56;
        int a3 = a1 + a2;
        System.out.println("a3 = " + a3);
    }
}
