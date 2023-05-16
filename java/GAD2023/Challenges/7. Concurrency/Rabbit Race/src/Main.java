public class Main {
    public static void main(String[] args) {
        for (int i = 0; i <= 5; i++) {
            new RabbitThread(i).start();
        }

        for (int i = 6; i <= 10; i++) {
            Runnable runnable = new RabbitRunnable(i);
            new Thread(runnable).start();
        }
    }
}