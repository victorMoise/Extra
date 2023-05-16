package visitor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Element> elements = new ArrayList<Element>();
        elements.add(new Book());
        elements.add(new Film());
        elements.add(new Song());

        TimeVisitor timeVisitor = new TimeVisitor();
        for (Element el: elements) {
            el.accept(timeVisitor);
        }

        System.out.println("Total time: " + timeVisitor.getTime());

        PriceVisitor priceVisitor = new PriceVisitor();
        for (Element el: elements) {
            el.accept(priceVisitor);
        }

        System.out.println("Total price: " + priceVisitor.getPrice());
    }
}
