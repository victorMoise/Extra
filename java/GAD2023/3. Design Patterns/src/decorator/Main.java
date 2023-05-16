package decorator;

public class Main {
    public static void main(String[] args) {
        Beverage coffeeWithMilk = new Coffee();
        coffeeWithMilk = new Milk(coffeeWithMilk);
        System.out.println(coffeeWithMilk.getDescription());

        Beverage coffee = new Coffee();
        Topping chocolate = new Chocolate(coffee);
        Topping whip = new Whip(chocolate);
        Milk milk = new Milk(whip);
        System.out.println(milk.getDescription());
        System.out.println(milk.getPrice());
    }
}
