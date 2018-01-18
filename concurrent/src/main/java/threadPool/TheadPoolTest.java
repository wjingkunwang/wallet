package threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TheadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();
        final Random random = new Random();
        final List<Integer> list = new ArrayList<Integer>();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        //这块代码是监控new Thread(new MonitorThreadPoolUtil((ThreadPoolExecutor) executorService,1)).start();
        for (int i = 0; i < 100000; i++) {

            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });

        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(list.size());

    }
}
