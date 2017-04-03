package com.bjsxt.proxy.jdkProxy;


import java.lang.reflect.Proxy;

/**
 * Created by wjk on 16/1/11.
 */
public class TestForumService {
    public static void main(String[] args) {
        //希望被代理的目标类
        ForumService target = new ForumServiceImpl();
        //将目标业务类和横切代码编制在一起
        PerformanceHandler handler = new PerformanceHandler(target);


        ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);

        proxy.removeForum(10);
        System.out.println("*****************");
        proxy.removeTopic(120);
    }
}
