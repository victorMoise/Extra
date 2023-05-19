package Builder_PizzaShop;

public class Pizza {
    private String dough;
    private String sauce;
    private boolean cheese;
    private boolean pepperoni;
    private boolean mushrooms;

    private Pizza(PizzaBuilder builder) {
        this.dough = builder.dough;
        this.sauce = builder.sauce;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
    }

    public static class PizzaBuilder {
        private String dough;
        private String sauce;
        private boolean cheese;
        private boolean pepperoni;
        private boolean mushrooms;

        public PizzaBuilder(String dough, String sauce) {
            this.dough = dough;
            this.sauce = sauce;
        }

        public PizzaBuilder addCheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public PizzaBuilder addPepperoni(boolean pepperoni) {
            this.pepperoni = pepperoni;
            return this;
        }

        public PizzaBuilder addMushrooms(boolean mushrooms) {
            this.mushrooms = mushrooms;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", mushrooms=" + mushrooms +
                '}';
    }
}

