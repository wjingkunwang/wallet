package juc.lock.ReentrantReadWriteLockDemo.jiangji;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *  在 1 位置线程获取锁，假设A线程获取到锁，则其他线程等待，
 *  如果在3出没有获取读锁，则又有线程获取写锁，则继续修改数据，则这个时候修改的数据线程A不知道的，其实就是数据对应A不可显
 *
 *  但是cacheValid这个其实可以阻止一下它继续修改数据
 */
class CachedData {
    Object data;
    volatile boolean cacheValid;
    final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    void processCachedData() {
        rwl.readLock().lock();
        if (!cacheValid) {
            // Must release read lock before acquiring write lock
            rwl.readLock().unlock();
            rwl.writeLock().lock();// 1
            try {
                // Recheck state because another thread might have
                // acquired write lock and changed state before we did.
                if (!cacheValid) {//2
//                    data =
                    cacheValid = true;
                }
                // Downgrade by acquiring read lock before releasing write lock
                rwl.readLock().lock();//3
            } finally {
                rwl.writeLock().unlock(); // Unlock write, still hold read
            }
        }

        try {
//            use(data);
        } finally {
            rwl.readLock().unlock();
        }
    }
}