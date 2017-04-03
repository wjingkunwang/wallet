package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wjk on 16/8/16.
 */
public class Composite extends Component {
    private String name;
    private List<Component> components;

    public Composite(String name) {
        this.name = name;
    }

    public void addChild(Component child) {
        if (components == null) {
            components = new ArrayList<Component>();
        }
        components.add(child);
    }

    @Override
    public void printStruct(String preStr) {
        //先输出自己
        System.out.println(preStr + "+" + name);
        //输出自组件
        if (components != null) {
            preStr += " ";
            for (Component component : components) {
                component.printStruct(preStr);
            }

        }

    }
}
