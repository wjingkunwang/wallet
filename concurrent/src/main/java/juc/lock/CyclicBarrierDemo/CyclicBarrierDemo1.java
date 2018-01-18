package juc.lock.CyclicBarrierDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *  演示await超时后，CyclicBarrier 中的Runnable不执行
 */
public class CyclicBarrierDemo1 {
    static CyclicBarrier c = new CyclicBarrier(2, new A());

    public static void main(String[] args) {

        new Thread(new Runnable() {

            public void run() {
                try {
                    c.await(1, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();

        try {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }            c.await();

        } catch (Exception e) {

        }
        System.out.println(2);
    }

    static class A implements Runnable {

        public void run() {
            System.out.println("所有的线程都到了");
        }

    }
}
