package invoker;

import lombok.Data;

import java.util.List;

/**
 * Created by wjk on 16/7/1.
 */
@Data
public class Invoker {
    private List<Command> commandList;

    public void runCommand() {
        for (Command command : commandList) {
            command.execute();
        }
    }
}
