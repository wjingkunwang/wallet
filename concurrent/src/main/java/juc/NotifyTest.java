package juc;

/**
 * Created by wjk on 2017/7/25.
 */
public class NotifyTest {

    private String flag[] = {"true"};

    class NotifyThread extends Thread {
        public NotifyThread(String name) {
            super(name);
        }

        public void run() {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (flag) {
                //flag的对象变为false,对象发生改变
                flag[0] = "false";
                flag.notifyAll();
            }
        }
    }

    class WaitThread extends Thread {
        public WaitThread(String name) {
            super(name);
        }

        public void run() {
            synchronized (flag) {
                while (flag[0].equals("true")) {
                    System.out.println(getName() + " begin waiting!");
                    long waitTime = System.currentTimeMillis();
                    try {
                        flag.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    waitTime = System.currentTimeMillis() - waitTime;
                    System.out.println("wait time :" + waitTime);
                }
                System.out.println(getName() + " end waiting!");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread Run!");
        NotifyTest test = new NotifyTest();
        NotifyThread notifyThread = test.new NotifyThread("notify01");
        WaitThread waitThread01 = test.new WaitThread("waiter01");
        notifyThread.start();
        waitThread01.start();
    }

}