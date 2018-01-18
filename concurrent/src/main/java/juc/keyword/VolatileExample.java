package juc.keyword;

/**
 * Created by wjk on 2017/11/29.
 */
public class VolatileExample {
    int x = 0;
    volatile boolean v = false;

    private void write() {
        x = 42;
        v = true;
        System.out.println("现在V的值:" + v);
    }

    private void read() {
        while (!v) {
//            System.out.println("-----");
        }
        System.out.println("我是猴子");
    }

    public static void main(String[] args) throws Exception {
        final VolatileExample example = new VolatileExample();

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                example.read();
            }
        });

        thread2.start();
        Thread.sleep(1000);

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                example.write();
            }
        });
        thread1.start();

    }
}