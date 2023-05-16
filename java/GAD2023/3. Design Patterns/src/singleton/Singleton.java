package singleton;

public class Singleton {
    private static Singleton instance; // private static instance

    private Singleton() {} // private constructor

    // public static method
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}
