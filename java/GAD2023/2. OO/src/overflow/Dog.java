package overflow;

public class Dog {
    public void bark() {
        System.out.println("Bark");
        // barkMany(1);
    }

    public void barkMany(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Bark");
        }
    }
}
