package composite;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<Shape>();
        shapes.add(new Triangle());
        shapes.add(new Circle());
        shapes.add(new Square());

        for (Shape shape: shapes) {
            shape.draw();
        }
    }
}
