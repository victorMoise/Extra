public class Interference {
    public static int v = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("before " + v);
        Runnable runnable = () -> {
            System.out.println("v = " + v);
            v += 1;
        };

        for (int i = 0; i <= 500; i++) {
            (new Thread(runnable)).start();
        }
        Thread.sleep(100);
        System.out.println("after " + v);
    }
}
