abstract class Animal {
    protected int legs;
    protected Animal(int legs) {
        this.legs = legs;
    }

    public void walk() {
        System.out.println("Animal with " + this.legs + " legs walks.");
    }

    abstract void eat();
}
