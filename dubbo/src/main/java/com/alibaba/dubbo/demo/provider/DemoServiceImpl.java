package com.alibaba.dubbo.demo.provider;

import com.alibaba.dubbo.demo.DemoService;

/**
 * Created by wjk on 2017/12/22.
 */
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}