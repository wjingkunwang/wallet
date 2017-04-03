package db_pool;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;

/**
 * Created by wjk on 2017/4/3.
 */
public class MyPoolImpl implements IMyPool {
    private static String jdbcDriver;
    private static String jdbcUrl;
    private static String userName;
    private static String pwd;

    private static int initCount;
    private static int stepCount;
    private static int poolMaxSize;

    private static Vector<PooledConnection> pooledConnections = new Vector<PooledConnection>();

    public MyPoolImpl() {
        init();
    }

    private void init() {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        jdbcDriver = properties.getProperty("jdbcDriver");
        jdbcUrl = properties.getProperty("jdbcUrl");
        userName = properties.getProperty("userName");
        pwd = properties.getProperty("pwd");

        initCount = Integer.valueOf(properties.getProperty("initCount"));
        stepCount = Integer.valueOf(properties.getProperty("stepCount"));
        poolMaxSize = Integer.valueOf(properties.getProperty("poolMaxSize"));

        try {
            Driver sqlDriver = (Driver) Class.forName(jdbcDriver).newInstance();
            DriverManager.registerDriver(sqlDriver);
            createConnection(initCount);//初始化连接池
        } catch (Exception e) {
            System.out.println("创建驱动异常 " + e.getMessage());
        }
    }


    public PooledConnection getConnection() {
        if (pooledConnections.size() == 0) {
            throw new RuntimeException("获取连接失败，没有连接");
        }
        PooledConnection pooledConnection = getRealConnection();
        while (pooledConnection == null) {
            createConnection(stepCount);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pooledConnection = getRealConnection();
        }

        return pooledConnection;
    }

    private synchronized PooledConnection getRealConnection() {
        for (PooledConnection pooledConnection : pooledConnections) {
            if (!pooledConnection.isBusy()) {
                try {
                    Connection connection = pooledConnection.getConn();
                    if (!connection.isValid(2000)) {//判断数据库连接是否有效
                        Connection validConnection = DriverManager.getConnection(jdbcUrl, userName, pwd);
                        pooledConnection.setConn(validConnection);
                        pooledConnection.setBusy(true);
                        return pooledConnection;
                    } else {
                        return pooledConnection;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;

    }

    public void createConnection(int count) {
        if (pooledConnections.size() + count > poolMaxSize) {
            throw new RuntimeException("创建数据库连接失败，连接超过最大值");
        }

        for (int i = 0; i < count; i++) {
            try {
                Connection connection = DriverManager.getConnection(jdbcUrl, userName, pwd);
                PooledConnection pooledConnection = new PooledConnection(connection, false);
                pooledConnections.add(pooledConnection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
