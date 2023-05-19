package Builder_PizzaShop;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder("thin crust", "tomato")
                .addCheese(true)
                .addPepperoni(true)
                .addMushrooms(true)
                .build();

        System.out.println(pizza.toString());

    }
}
