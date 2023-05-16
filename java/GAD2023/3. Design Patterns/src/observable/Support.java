package observable;

import java.util.ArrayList;
import java.util.List;

public class Support {
    List<Subscriber> subscribers = new ArrayList<Subscriber>();

    public void subscribe(Subscriber sub) {
        subscribers.add(sub);
    }

    public void notify(String article) {
        subscribers.forEach(subscriber -> subscriber.getNews(article));
    }
}
