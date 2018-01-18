package com.alibaba.dubbo.demo.provider;

import com.alibaba.dubbo.demo.DemoService;
import com.alibaba.dubbo.demo.UserService;

/**
 * Created by wjk on 2017/12/22.
 */
public class UserServiceImpl implements UserService {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}