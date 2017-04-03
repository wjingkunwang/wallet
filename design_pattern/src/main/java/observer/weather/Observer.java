package observer.weather;

/**
 * Created by wjk on 16/2/26.
 */
public interface Observer {
    public void update(float temp, float humidity, float pressure);
}
