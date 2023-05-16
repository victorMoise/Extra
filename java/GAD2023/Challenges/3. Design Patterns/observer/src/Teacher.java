import java.util.ArrayList;

public class Teacher implements ObservedSubject{
    private ArrayList<Observer> observers = new ArrayList<>();

    public void register(Observer obj) {
        observers.add(obj);
    }
    
    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    public void notifyObservers(String message) {
        for (Observer observer: observers) {
            observer.update(message);
        }
    }

    public void teach(String topic) {
        notifyObservers(topic);
    }
}
