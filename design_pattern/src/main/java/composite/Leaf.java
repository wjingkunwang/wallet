package composite;

import lombok.AllArgsConstructor;

/**
 * Created by wjk on 16/8/16.
 */
@AllArgsConstructor
public class Leaf extends Component {
    private String name;

    @Override
    public void printStruct(String preStr) {
        System.out.println(preStr + "-" + name);
    }
}
