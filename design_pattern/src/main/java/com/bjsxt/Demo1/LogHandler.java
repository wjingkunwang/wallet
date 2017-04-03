package com.bjsxt.Demo1;

/**
 * Created by wjk on 16/1/11.
 */
public class LogHandler implements Moveable{
    private Moveable moveable;

    public LogHandler(Moveable moveable) {
        this.moveable = moveable;
    }

    public void move() {
        moveable.move();
        System.out.println("记录日志~~~~");
    }
}
