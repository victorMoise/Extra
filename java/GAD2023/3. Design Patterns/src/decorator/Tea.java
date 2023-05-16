package decorator;

public class Tea implements Beverage {
    @Override
    public String getDescription() {
        return "Lemon Tea";
    }

    @Override
    public Integer getPrice() {
        return 5;
    }
}
