package observer.weather;

/**
 * Created by wjk on 16/2/26.
 */
public class CurrentConditionDisplay implements DisplayElement, Observer {
    private float temperature;
    private float humidity;
    private Subject weatherDate;


    /**
     * 将被观察者通过构造方法传递进来、并将此观察者注册到被观察者中
     * 这样观察者和被观察者就完美的结合了
     *
     * @param weatherDate
     */
    public CurrentConditionDisplay(Subject weatherDate) {
        super();
        this.weatherDate = weatherDate;
        this.weatherDate.registerObserver(this);
    }


    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        disPlay();
    }


    public void disPlay() {
        System.out.println("Current comditions : " + temperature + " F degrees and " + humidity + "% humidity");
    }
}
