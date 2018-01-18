package juc.lock.ReentrantReadWriteLockDemo;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by wjk on 2017/11/28.
 */
public class TestSearchMain {
    public static void main(String[] args) {

        SearchServer searchServer = new SearchServer();

        searchServer.put("湖南", "湖南");
        searchServer.put("湖北", "湖北");
        searchServer.put("北京", "北京");
        searchServer.put("河北", "河北");
        searchServer.put("河南", "河南");
        Set<String> set = (Set) searchServer.search("北", 10);

        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());

        }
    }
}
