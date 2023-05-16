package observable;

public class Website {
    private String product;
    private Support support = new Support();

    public void changeProduct(String product) {
        this.product = product;
        support.notify(product);
    }

    public void subscribe(Subscriber sub) {
        support.subscribe(sub);
    }

}
