import java.util.Objects;

public class Heels implements Shoe {
    int size;
    String color;

    public Heels(String color, int size) {
        this.size = size;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Heels heels)) return false;
        return size == heels.size && Objects.equals(color, heels.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, color);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getColor() {
        return color;
    }
}
