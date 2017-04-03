package state;

/**
 * Created by wjk on 16/7/9.
 */
public class Client {
    public static void main(String[] args) {
        FreeRoom freeRoom = new FreeRoom();
        BookedRoom bookedRoom = new BookedRoom();
        freeRoom.handle();
        RoomContext context = new RoomContext();
        context.setState(bookedRoom);
    }
}
