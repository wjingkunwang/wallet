package memento.Demo;

/**
 * Created by wjk on 16/7/8.
 */
public class Client {
    public static void main(String[] args) {
        FlowAMock mock = new FlowAMock("testFlow");
        mock.runPhaseOne();

        FlowAMementoCareTaker careTaker = new FlowAMementoCareTaker();
        FlowAMockMemento memento = mock.createMemento();
        careTaker.setMemento(memento);

        mock.schema1();
        mock.setMemento(memento);
        mock.schema2();
    }
}
