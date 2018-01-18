package jvm.gc;

/**
 * 判断无用的类
 * <p>
 * 引用计数法
 * <p>
 * 可达性分析法
 * <p>
 * 验证使用的可达性分析法
 */
public class CheckClass {

    public static void main(String[] args) throws InterruptedException {
        CheckClass obj1 = new CheckClass();
        CheckClass obj2 = new CheckClass();
        obj1 = obj2;
        obj2 = obj1;

        obj1 = null;
        obj2 = null;

        System.gc();
        Thread.sleep(1000);
        System.out.println(obj1);
        System.out.println(obj2);
    }
}
