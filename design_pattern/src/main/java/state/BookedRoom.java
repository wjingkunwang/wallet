package state;

/**
 * Created by wjk on 16/7/9.
 */
public class BookedRoom implements State {
    public void handle() {
        System.out.println("房子预定完,没地住了");
    }
}
