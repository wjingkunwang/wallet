package db_pool;

/**
 * 连接池
 */
public interface IMyPool {
    //获取连接
    PooledConnection getConnection();

    //创建连接
    void createConnection(int count);
}
