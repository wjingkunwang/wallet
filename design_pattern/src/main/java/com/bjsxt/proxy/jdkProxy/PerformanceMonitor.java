package com.bjsxt.proxy.jdkProxy;

/**
 * Created by wjk on 16/1/11.
 */
public class PerformanceMonitor {

    public static void begin(String method){
        System.out.println("begin monitor...");
    }

    public static void end(){
        System.out.println("end monitor");
    }
}
