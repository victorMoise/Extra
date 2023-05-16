import java.util.Objects;

public class Boot implements Shoe {
    int size;
    String color;
    public Boot(String color, int size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boot boot)) return false;
        return size == boot.size && Objects.equals(color, boot.color);
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
