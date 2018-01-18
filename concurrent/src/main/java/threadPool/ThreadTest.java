package threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by wjk on 2017/11/24.
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Long start=System.currentTimeMillis();
        final Random random=new Random();
        final List<Integer> list=new ArrayList<Integer>();
        Thread thread =  new Thread(new Runnable() {
             @Override
             public void run() {
                 for (int i = 0; i < 100000; i++) {
                     list.add(random.nextInt());
                 }
             }
         });
        thread.start();
        thread.join();

        System.out.println(System.currentTimeMillis()-start);
        System.out.println(list.size());

    }
}
