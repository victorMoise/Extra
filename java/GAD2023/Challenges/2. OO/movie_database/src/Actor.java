import java.util.Arrays;

public class Actor {
    private int age;
    private String name;
    private Prize[] prizes;

    public Actor(int age, String name, Prize[] prizes) {
        this.age = age;
        this.name = name;
        this.prizes = prizes;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", prizes=" + Arrays.toString(prizes) +
                '}';
    }
}
