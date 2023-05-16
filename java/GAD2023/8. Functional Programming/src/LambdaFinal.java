public class LambdaFinal {
    private int a =10;
    public void calculate() {
        a += 1;
        Runnable r = () -> {
            System.out.println(a);
        };
    }
}
