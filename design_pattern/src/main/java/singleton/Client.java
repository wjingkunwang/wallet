package singleton;


import java.lang.reflect.Constructor;

/**
 * Created by wjk on 16/2/3.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        SingletonDemo2 demo = SingletonDemo2.getInstance();
        SingletonDemo2 demo1 = SingletonDemo2.getInstance();
        System.out.println(demo);
        System.out.println(demo1);


        Class<SingletonDemo2> singletonDemo2Class = (Class<SingletonDemo2>) Class.forName("singleton.SingletonDemo2");
        Constructor<SingletonDemo2> constructor = singletonDemo2Class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonDemo2 demo2 = constructor.newInstance();
        SingletonDemo2 demo3 = constructor.newInstance();
        System.out.println(demo2);
        System.out.println(demo3);
/*
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/wjk/Desktop/a.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(demo);
        objectOutputStream.close();;
        fileOutputStream.close();


        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/wjk/Desktop/a.txt"));
        SingletonDemo2 singletonDemo2 =(SingletonDemo2) objectInputStream.readObject();
        System.out.println(singletonDemo2);*/
    }
}
