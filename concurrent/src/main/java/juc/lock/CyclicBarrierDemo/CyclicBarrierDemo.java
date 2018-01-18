package juc.lock.CyclicBarrierDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier可以重用，在释放统一generation线程后，可以通过重置状态和计数来重用
 * 1. 主要点：底层通过ReentrantLock condition  实现
 * 2. 栅栏可以是重复使用的，当满了后可以new 新的Generation
 * 3. 超时话，CyclicBarrier中的runable不执行，但是等待的继续执行
 *
 * CyclicBarrier中我们定义5个线程为同一代，我们起10个线程来测试是否可以重用，如何可以将输出两个"CyclicBarrier's parties is:5"
 */
public class CyclicBarrierDemo {

    private static int SIZE = 5;
    private static CyclicBarrier cb;

    public static void main(String[] args) {

        cb = new CyclicBarrier(SIZE, new Runnable() {
            public void run() {
                System.out.println("CyclicBarrier's parties is: " + cb.getParties());
            }
        });


        // 新建10个任务
        for (int i = 0; i < 10; i++)
            new InnerThread().start();
    }

    static class InnerThread extends Thread {
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " wait for CyclicBarrier.");

                // 将cb的参与者数量加1
                cb.await();
                // cb的参与者数量等于5时，才继续往后执行
                System.out.println(Thread.currentThread().getName() + " continued.");
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
