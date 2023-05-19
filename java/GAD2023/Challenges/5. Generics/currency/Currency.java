package currency;

public class Currency {
    private Float value;
    private String name;

    public Currency(Float value, String name) {
        this.value = value;
        this.name = name;
    }

    public Float getValue() {
        return value;
    }
}
