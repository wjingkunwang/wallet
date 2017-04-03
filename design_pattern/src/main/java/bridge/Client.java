package bridge;

/**
 * Created by wjk on 16/3/17.
 */
public class Client {
    public static void main(String[] args) {
        Human man = new Man();
        AbstractRoad road = new SpeedWay();
        road.abstractCar = new Car();
        man.road = road;
        man.run();
    }
}
