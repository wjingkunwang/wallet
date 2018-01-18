package jvm.initialization;

/**
 * Created by wjk on 2017/11/22.
 */
public class Singleton {
    private static Singleton mInstance = new Singleton();// 位置1
    public static int counter1;
    public static int counter2 = 0;
//        private static Singleton mInstance = new Singleton();// 位置2
    private Singleton() {
        counter1++;
        counter2++;
    }

    public static Singleton getInstance() {
        return mInstance;
    }
}

class InitDemo {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("counter1: " + singleton.counter1);
        System.out.println("counter2: " + singleton.counter2);
    }
}
