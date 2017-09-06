package db_pool;

/**
 * 内部类实现单例模式
 */
public class PoolManager {
    private static class Pool {
        private static MyPoolImpl myPool = new MyPoolImpl();
    }

    public static MyPoolImpl getPool() {
        return Pool.myPool;
    }
}
