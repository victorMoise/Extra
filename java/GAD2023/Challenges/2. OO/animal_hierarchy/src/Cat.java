public class Cat extends Animal implements Pet{
    private String name;

    public Cat(String name) {
        super(4);
        this.name = name;
    }

    public Cat() {
        this("");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void play() {
        System.out.println("Cat named " + this.name + " plays.");
    }

    public void eat() {
        System.out.println("Cat named " + this.name + " eats.");
    }
}
