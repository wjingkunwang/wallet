package jvm.initialization;

/**
 * Created by wjk on 2017/11/20.
 */
public class StaticDemo {

    static{
        a = 300;
//        System.out.println(a);
    }
    public static int a = 10;

    public static void main(String[] args) {
        StaticDemo demo = new StaticDemo();
        System.out.println(demo.a);
    }
}
