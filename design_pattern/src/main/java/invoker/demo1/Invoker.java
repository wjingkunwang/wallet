package invoker.demo1;

/**
 * Created by wjk on 2017/12/21.
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    void invoke() {
        System.out.println("执行命令啦");
        command.execute();
    }
}
