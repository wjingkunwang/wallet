package com.bjsxt.Demo;

/**
 * Created by wjk on 16/1/11.
 */
public class TimeHandlerTank extends Tank {
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        super.move();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("move时间: " + String.valueOf(end - start));
    }
}
