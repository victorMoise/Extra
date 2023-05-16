package decorator;

public class Coffee implements Beverage {
    @Override
    public String getDescription() {
        return "Coffee";
    }

    @Override
    public Integer getPrice() {
        return 10;
    }
}
