package invoker.demo1;

/**
 * Created by wjk on 2017/12/21.
 */
public class ConcreateCommand implements Command {
    private Receiver receiver;

    public ConcreateCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        System.out.println("我才不执行了，让我小弟去执行吧");
        receiver.execute();
    }
}
