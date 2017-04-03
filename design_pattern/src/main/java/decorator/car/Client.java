package decorator.car;

/**
 * Created by wjk on 16/7/9.
 */
public class Client {
    public static void main(String[] args) {
        Car yellowCar =new YellowCar(new Decorator(new BMW()));
        yellowCar.detail();

        Car blackCar = new BlackCar(new Decorator(new BMW()));
        blackCar.detail();
    }
}
