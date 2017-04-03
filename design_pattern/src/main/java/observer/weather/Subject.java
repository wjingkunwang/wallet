package observer.weather;

/**
 * Created by wjk on 16/2/26.
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}
