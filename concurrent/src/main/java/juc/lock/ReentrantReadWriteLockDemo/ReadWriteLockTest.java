package juc.lock.ReentrantReadWriteLockDemo;

import java.util.Random;

/**
 * http://caoxyemail.iteye.com/blog/2129840
 * http://blog.csdn.net/prestigeding/article/details/53286756
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {

        /* 创建ReadWrite对象 */
        final ReadWrite readWrite = new ReadWrite();

        /* 创建并启动3个读线程 */
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    readWrite.get();

                }
            }).start();

            /*创建3个写线程*/
            new Thread(new Runnable() {

                @Override
                public void run() {
                    /*随机写入一个数*/
                    readWrite.put(new Random().nextInt(8));

                }
            }).start();
        }

    }
}
