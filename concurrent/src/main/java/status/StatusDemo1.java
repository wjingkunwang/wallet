package status;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 查看线程状态
 * jps | grep 'AppMain' |awk '{print $1}' |  xargs jstack
 */
public class StatusDemo1 {
      static  ReentrantLock lock = new ReentrantLock();

    public static void read() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读数据");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void write() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写数据");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                StatusDemo1.read();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                StatusDemo1.write();
            }
        }).start();

    }
}
