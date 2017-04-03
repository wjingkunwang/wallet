package adapter;

/**
 * Created by wjk on 16/8/14.
 */
public class TwoPlugAdapterExtends extends GBTwoPlug implements ThreePlugIf {
    public void powerWithThree() {
        System.out.println("借助继承适配器");
        this.powerWithTwo();
    }
}
