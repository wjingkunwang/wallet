package decorator.car;

/**
 * Created by wjk on 16/7/9.
 */
public class BlackCar extends Decorator {
    public BlackCar(Car car) {
        super(car);
    }

    @Override
    public void detail() {
        System.out.print("黑色");
        super.detail();
    }
}
