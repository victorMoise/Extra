import java.util.Objects;

public class Running implements Shoe {
    int size;
    String color;
    public Running(String color, int size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Running running)) return false;
        return size == running.size && Objects.equals(color, running.color);
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
