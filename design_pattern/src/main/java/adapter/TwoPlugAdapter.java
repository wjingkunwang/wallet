package adapter;

/**
 * Created by wjk on 16/8/14.
 */
public class TwoPlugAdapter implements ThreePlugIf {

    private GBTwoPlug plug;

    public TwoPlugAdapter(GBTwoPlug plug) {
        this.plug = plug;
    }

    public void powerWithThree() {
        System.out.println("借助对象适配器");
        //对适配器原有接口方法的调用被委托给新接口的实例的特定方法
        plug.powerWithTwo();
    }
}
