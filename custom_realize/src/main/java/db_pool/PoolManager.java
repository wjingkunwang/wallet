package db_pool;

/**
 * Created by wjk on 2017/4/3.
 */
public class PoolManager {
    private static class Pool {
        private static MyPoolImpl myPool = new MyPoolImpl();
    }

    public static MyPoolImpl getPool() {
        return Pool.myPool;
    }
}
