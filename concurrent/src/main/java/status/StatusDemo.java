package status;

/**
 * http://pic002.cnblogs.com/images/2012/463736/2012121621210332.jpg
 * 线程状态测试
 *
 * 对象锁（线程在阻塞状态）
 *
 * jstack 获得的线程堆栈
 * http://upload-images.jianshu.io/upload_images/2412598-1c8c14d00de1e280.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240
 *
 * 如此是并发包下的锁呢
 */
public class StatusDemo {
    static Object lock = new Object();

    public static void read() {
        synchronized (lock) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("读数据");
        }
    }

    public static void write() {
        synchronized (lock) {
            System.out.println("写数据");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                StatusDemo.read();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                StatusDemo.write();
            }
        }).start();

    }
}
