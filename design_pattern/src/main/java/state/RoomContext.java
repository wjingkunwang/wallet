package state;

/**
 * Created by wjk on 16/7/9.
 */
public class RoomContext {
    private State state;


    public void setState(State state){
        System.out.println("改变状态");
        state.handle();
    }
}
