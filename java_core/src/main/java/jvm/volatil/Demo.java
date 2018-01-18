package jvm.volatil;

/**
 * private boolean flag = false;
 * 代码会一直运行
 * private volatile boolean flag = false;
 * 运行一段时间后会停止
 */
public class Demo extends Thread {

    private boolean flag = false;

    @Override
    public void run() {
        int i = 0;
        while (!flag) {
            i++;
        }
        System.out.println(i);
    }

    public void stopE() {
        flag = true;
    }

    public static void main(String[] args) throws InterruptedException {
        Demo demo = new Demo();
        demo.start();
        Thread.sleep(1000); //让demo先启动，防止demo.stopE()先执行，导致输出0
        demo.stopE();
    }
}
