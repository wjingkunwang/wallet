package thread.core.futureTaskDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTask的demo
 */
public class FutureTaskTest {
    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();
        final FutureTask<Integer> myFutureTask = new FutureTask(myCallable);
        new Thread(myFutureTask).start();
        System.out.println("已经提交了任务");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("hfhadhf");
                    System.out.println(myFutureTask.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            System.out.println(myFutureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("任务执行完毕");
    }

    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("正在处理任务－－－－>" + Thread.currentThread().getName());
            Thread.sleep(5000);
            return 100;
        }
    }
}
