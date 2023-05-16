package decorator;

public class Chocolate extends Topping {
    public Chocolate(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return super.getDescription() + ", with Chocolate";
    }

    public Integer getPrice() {
        return super.getPrice() + 5;
    }
}
