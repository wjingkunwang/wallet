package com.bjsxt.Demo1;

/**
 * Created by wjk on 16/1/11.
 */
public class Test {
    public static void main(String[] args) {
        Moveable tank = new Tank();
        new LogHandler(new TimeHandler(tank)).move();
    }
}
