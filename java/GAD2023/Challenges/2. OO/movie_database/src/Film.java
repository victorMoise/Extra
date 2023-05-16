import java.util.Arrays;

public class Film {
    private int debutYear;
    private String name;
    private Actor[] actors;

    public Film(int debutYear, String name, Actor[] actors) {
        this.debutYear = debutYear;
        this.name = name;
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Film{" +
                "debutYear=" + debutYear +
                ", name='" + name + '\'' +
                ", actors=" + Arrays.toString(actors) +
                '}';
    }
}
