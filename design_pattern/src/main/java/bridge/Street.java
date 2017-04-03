package bridge;

/**
 * Created by wjk on 16/3/17.
 */
public class Street extends AbstractRoad {
    @Override
    public void run() {
        abstractCar.run();
        System.out.println("街道跑");
    }
}
