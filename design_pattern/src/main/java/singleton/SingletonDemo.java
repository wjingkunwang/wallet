package singleton;

/**
 * 保证一个类只有一个实例,并且提供一个访问该实例的全局访问点
 * (1)windows中的任务管理器
 * (2)操作系统的文件系统,一个操作系统只能有一个文件系统
 * (3)在servlet编程中,每个servlet也是单例
 * (4)springMVC中,控制器对象也是单例
 * (5)spring中的bean
 *
 * 减少系统开销
 *
 *
 * 饿汉式
 */
public class SingletonDemo {
    //类初始化的时候立即加载(没有延时加载的优势),由于加载类的时候天热的线程安全
    private static final SingletonDemo singleDemo = new SingletonDemo();
    //私有化构造器
    private SingletonDemo() {

    }
    //方法没有同步,调用效率高
    public static SingletonDemo getInstance(){
        return singleDemo;
    }

}
