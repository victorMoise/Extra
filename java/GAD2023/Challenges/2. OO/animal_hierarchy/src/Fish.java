public class Fish extends Animal implements Pet{
    private String name;
    public Fish() {
        super(0);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void walk() {
        System.out.println("Fish can't walk.");
    }

    public void eat() {
        System.out.println("Fish eat small water plants.");
    }

    public void play() {
        System.out.println("Fish named " + this.name + " plays.");
    }
}
