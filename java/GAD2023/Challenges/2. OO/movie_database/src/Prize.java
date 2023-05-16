public class Prize {
    private String name;
    private int year;
    public Prize(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Prize{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
