package bridge;

/**
 * Created by wjk on 16/3/17.
 */
public class Woman extends Human {
    @Override
    public void run() {
        System.out.print("女人开着");
        road.run();
    }
}
