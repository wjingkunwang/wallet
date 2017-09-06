package juc.lock.LockDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wjk on 17/1/22.
 */
public class ReentrantLockDemo {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock(false);

        MyThread t1 = new MyThread("t1", lock);
        MyThread t2 = new MyThread("t2", lock);
        MyThread t3 = new MyThread("t3", lock);
        t1.start();
//        t1.interrupt();
//        t2.start();
//        t3.start();
    }
}

class MyThread extends Thread {
    private Lock lock;
    public MyThread(String name, Lock lock) {
        super(name);
        this.lock = lock;
    }

    /**
     * lock()在try{}catch(){}外部
     */
    public void run () {
        try {
//            lock.lock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}