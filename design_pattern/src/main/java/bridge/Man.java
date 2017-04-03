package bridge;

/**
 * Created by wjk on 16/3/17.
 */
public class Man extends Human {
    @Override
    public void run() {
        System.out.print("男人开着");
        road.run();
    }
}
