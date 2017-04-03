package singleton;

/**
 * 真正用的时候加载
 * 资源的利用效率高,但是每次调用的时候同步,并发效率较低
 */
public class SingletonDemo1 {
    //调用的时候加载
    private static SingletonDemo1 instance = null;

    //私有化构造器
    private SingletonDemo1() {

    }

    //方法同步,调用效率低
    public static synchronized SingletonDemo1 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo1();
        }
        return instance;
    }
}
