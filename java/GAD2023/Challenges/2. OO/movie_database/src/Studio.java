import java.util.Arrays;

public class Studio {
    private String name;
    private Film[] films;

    public Studio(String name, Film[] films) {
        this.name = name;
        this.films = films;
    }

    @Override
    public String toString() {
        return "Studio{" +
                "name='" + name + '\'' +
                ", films=" + Arrays.toString(films) +
                '}';
    }

    public Film[] getFilms() {
        return films;
    }
}
