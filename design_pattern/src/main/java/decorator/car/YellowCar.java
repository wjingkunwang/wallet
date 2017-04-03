package decorator.car;

/**
 * Created by wjk on 16/7/9.
 */

public class YellowCar extends Decorator {

    public YellowCar(Car car) {
        super(car);
    }

    @Override
    public void detail() {
        System.out.print("黄色");
        super.detail();
    }
}
