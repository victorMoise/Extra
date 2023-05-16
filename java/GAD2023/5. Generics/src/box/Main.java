package box;

public class Main {
    public static void main(String[] args) {
        Box box = new Box();
        box.set(233);
        Integer x = (Integer)box.get();
        System.out.println(x.floatValue());

        GenericBox<Integer> genericBox = new GenericBox<Integer>();
        genericBox.set(233);
        System.out.println(genericBox.get().floatValue());

        GenericBox<String> genericBoxString = new GenericBox<String>();
        genericBoxString.set("some text");
        System.out.println(genericBoxString.get());
    }
}
