package prototype;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Phone phone = new Phone(200, 300, "Samsung");
        Phone phone1 = phone.clone();
        System.out.println(phone1);
    }
}
