package juc.lock.CyclicBarrierDemo;

import com.google.gson.Gson;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 并行计算
 * <p>
 * 看了各种资料和书，大家一致的意见都是CountDownLatch是计数器，只能使用一次，而CyclicBarrier的计数器提供reset功能，可以多次使用。但是我不那么认为它们之间的区别仅仅就是这么简单的一点。我们来从jdk作者设计的目的来看，javadoc是这么描述它们的：
 * <p>
 * CountDownLatch: A synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes.
 * <p>
 * CyclicBarrier : A synchronization aid that allows a set of threads to all wait for each other to reach a common barrier point.
 * 从javadoc的描述可以得出：
 * <p>
 * CountDownLatch：一个或者多个线程，等待其他多个线程完成某件事情之后才能执行；
 * CyclicBarrier：多个线程互相等待，直到到达同一个同步点，再继续一起执行。
 * 对于CountDownLatch来说，重点是“一个线程（多个线程）等待”，而其他的N个线程在完成“某件事情”之后，可以终止，也可以等待。而对于CyclicBarrier，重点是多个线程，在任意一个线程没有完成，所有的线程都必须等待。
 * <p>
 * CountDownLatch是计数器，线程完成一个记录一个，只不过计数不是递增而是递减，而CyclicBarrier更像是一个阀门，需要所有线程都到达，阀门才能打开，然后继续执行。
 */
public class CyclicBarrierUseSservice implements Runnable {
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4, this);
    private static ExecutorService executor = Executors.newFixedThreadPool(4);
    private ConcurrentHashMap<String, Integer> count = new ConcurrentHashMap();
    Gson gson = new Gson();

    @Override
    public void run() {
        int result = 0;
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            result += entry.getValue();
        }

        count.put(Thread.currentThread().getName() + "_result", result);
        System.out.println(gson.toJson(count));
    }

    public void calculate() {
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    count.put(Thread.currentThread().getName(), 10);
                    try {
                        System.out.println(Thread.currentThread().getName() + "_waiting");
                        cyclicBarrier.await();
                        System.out.println(Thread.currentThread().getName() + "_working");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        new CyclicBarrierUseSservice().calculate();
        executor.shutdown();
    }
}
