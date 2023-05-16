public class Main {
    public static void main(String[] args) {
        Spider spider = new Spider();
        spider.walk();
        spider.eat();
        System.out.println();

        Cat cat = new Cat("max");
        cat.play();
        cat.setName("ana");
        cat.eat();
        System.out.println();

        Fish fish = new Fish();
        fish.setName("Mircea");
        fish.play();
        fish.walk();
        System.out.println();

        //upcasting
        Animal animal = cat;
        animal.walk();
        animal.eat();   //still has the cat eat() method
        System.out.println();

        Pet pet1 = new Cat("max");
        Pet pet2 = new Fish();
        pet2.setName("marcel");
        pet1.play();
        pet2.play();
    }
}