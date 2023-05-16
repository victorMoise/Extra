package overflow;

public class PoliteDog extends Dog{
    public void barkMany(int n) {
        System.out.println("I say in a very polite way: ");
        for (int i = 0; i < n; i++) {
            bark();
        }
    }
}
