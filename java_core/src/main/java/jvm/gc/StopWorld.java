package jvm.gc;

/**
 * Created by wjk on 2017/11/26.
 */
public class StopWorld extends Thread {
    long start = System.currentTimeMillis();
    @Override
    public void run() {
        while (true){
            System.out.println(System.currentTimeMillis() - start);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        StopWorld stopWorld = new StopWorld();
        stopWorld.start();
    }
}
