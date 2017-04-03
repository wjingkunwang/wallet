package state;

/**
 * Created by wjk on 16/7/9.
 */
public class FreeRoom implements State {
    public void handle() {
        System.out.println("房子空闲可以入住");
    }
}
