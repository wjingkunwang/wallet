package bridge;

/**
 * Created by wjk on 16/3/17.
 */
public class SpeedWay extends AbstractRoad {
    @Override
    public void run() {
        abstractCar.run();
        System.out.println("高速路上跑");
    }
}
