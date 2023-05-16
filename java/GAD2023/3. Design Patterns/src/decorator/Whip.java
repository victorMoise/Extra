package decorator;

public class Whip extends Topping {
    public Whip(Beverage beverage) {
        super(beverage);
    }
    public String getDescription() {
        return super.getDescription() + ", with White Whip";
    }

    public Integer getPrice() {
        return super.getPrice() + 4;
    }
}
