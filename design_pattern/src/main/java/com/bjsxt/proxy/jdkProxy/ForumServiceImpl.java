package com.bjsxt.proxy.jdkProxy;

/**
 * Created by wjk on 16/1/11.
 */
public class ForumServiceImpl implements ForumService {
    public void removeTopic(int topicId) {
        System.out.println("模拟删除topic记录:" + topicId);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void removeForum(int forumId) {
        System.out.println("模拟删除formId:" + forumId);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
