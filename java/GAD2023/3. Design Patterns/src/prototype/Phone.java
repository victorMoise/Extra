package prototype;

public class Phone implements Cloneable{
    private int size;
    private int battery;
    private String name;

    public Phone(int size, int battery, String name) {
        this.size = size;
        this.battery = battery;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "size=" + size +
                ", battery=" + battery +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public Phone clone() throws CloneNotSupportedException {
        return (Phone)super.clone();
    }
}
