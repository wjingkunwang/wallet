package com.bjsxt.Demo1;

/**
 * Created by wjk on 16/1/11.
 */
public class TimeHandler implements Moveable{
    private Moveable moveable ;

    public TimeHandler(Moveable moveable) {
        this.moveable = moveable;
    }


    public void move() {
        long start = System.currentTimeMillis();
        moveable.move();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("move时间: " + String.valueOf(end - start));
    }
}
