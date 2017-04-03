package invoker;

import java.util.ArrayList;

/**
 * Created by wjk on 16/7/1.
 */
public class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        final Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.setCommandList(new ArrayList<Command>() {{
            add(command);
        }});

        invoker.runCommand();
    }
}
