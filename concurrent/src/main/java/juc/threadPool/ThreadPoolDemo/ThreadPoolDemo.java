package juc.threadPool.ThreadPoolDemo;

import java.util.concurrent.*;

/**
 * 1. 当线程池的线程数小于核心线程数目，生成线程执行任务
 *
 * 2. 当线程池数大于核心线程数目是，将其放在阻塞队列，（这里实现线程的复用）
 *
 *    首先认识到ThreadPoolExecutor中有个内部类Worker，这个类继承AQS实现Runnable，这样它就实现一把锁，同时它的属性有线程和任务
 *    ，重新run方法
 *
 *
 *    如何实现线程复用呢，就在run方法的runWork中，它会阻塞的从队列中取出任务在执行，没有取出任务则从HashSet<Worker> workers中删除
 *    worker，哪为何要实现一把锁呢，这个主要是为了判断线程是否空闲，每次线程执行任务的时候回获取锁，等没有执行完后释放锁，通过锁判断
 *    worker是否空闲。如果尝试获取锁没有成功则线程还不空闲
 *
 *    如何判断空闲的线程和退出空闲的线程呢？
 *
 *      while (task != null || (task = getTask()) != null) 线程阻塞的获取任务，获取任务后会获得worker锁，没有获取任务的则
 *      没有worker锁，所以根据当前线程是否持有锁来判断。这个在结束线程的时候使用，tryTerminate(),中断线程后，task = getTask()，
 *      获取任务是会catch异常,这样的话闲置worker一直拿不到任务。到最后所有的线程都拿不到任务，且任务为null，这样线程就退出runwork()
 *      接下来删除

 *
 *
 * 3. 当队列满后，添加线程直到最大线程数，若果达到最大线程则采取饱和策略
 *
 *    直接抛出异常
 *    丢弃最早入队的任务
 *    抛出异常
 *    使用主线程执行
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(3,10,1, TimeUnit.NANOSECONDS,arrayBlockingQueue);

        for (int i = 0; i < 100; i++) {
            System.out.println(executorService.getPoolSize());
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

        executorService.shutdown();
    }
}
