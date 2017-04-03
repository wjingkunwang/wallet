package decorator.car;

/**
 * Created by wjk on 16/7/9.
 */
public class Decorator implements Car {
    private Car car;

    public Decorator(Car car) {
        this.car = car;
    }

    public void detail() {
        car.detail();
    }
}
