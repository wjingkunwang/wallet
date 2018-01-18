package invoker.demo1;

/**
 * Created by wjk on 2017/12/21.
 */
public class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreateCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.invoke();
    }
}
