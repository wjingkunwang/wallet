package com.alibaba.dubbo.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wjk on 2017/12/22.
 */
public class Provider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"dubbo-provider.xml"});
        context.start();
        System.in.read(); // press any key to exit
    }
}