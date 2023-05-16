package observable;

public class Subscriber {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void getNews(String article) {
        System.out.println(this.name + " was notified with " + article);
    }
}
