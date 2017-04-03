package composite;

/**
 * Created by wjk on 16/8/16.
 */
public abstract class Component {
    //输出组件自身名称
    public abstract void printStruct(String preStr);

    public void addChild(Component child){}

    public void removeChild(Component child){}

    //返回某个索引对应的组件对象
    public Component getChild(int index){
        return null;
    };

}
