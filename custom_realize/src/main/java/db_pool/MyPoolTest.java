package db_pool;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wjk on 2017/4/3.
 */
public class MyPoolTest {
    private static MyPoolImpl myPool = PoolManager.getPool();

    public static void select() {
        PooledConnection pooledConnection = myPool.getConnection();
        ResultSet rs = pooledConnection.queryBySql("select * from student");
        System.out.println("线程名称: " + Thread.currentThread().getName());
        try {
            while (rs.next()) {
                System.out.println("id " + rs.getString("id") + "\t\t");
                System.out.println("name " + rs.getString("name") + "\t\t");
            }
            rs.close();
            pooledConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                public void run() {
                    select();
                }
            }).start();
        }
        //等待所有子线程执行完成
        System.in.read();
    }
}
