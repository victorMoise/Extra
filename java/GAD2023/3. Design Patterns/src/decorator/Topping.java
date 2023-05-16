package decorator;

public abstract class Topping implements Beverage {
    private Beverage beverage;
    public Topping(Beverage beverage) {
        this.beverage = beverage;
    }

    public Integer getPrice() {
        return beverage.getPrice();
    }

    public String getDescription() {
        return beverage.getDescription();
    }
}
