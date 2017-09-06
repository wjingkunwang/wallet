package juc;

/**
 * Created by wjk on 2017/7/25.
 */
public class SynchronizedDemo {

        private static String A = "A";

        public static void main(String[] args) {

            new SynchronizedDemo().deadLock();
        }

        private void deadLock() {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (A) {
                        A = "B";
                        try { Thread.currentThread().sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                        synchronized (A) {
                            A = "B";
                            System.out.println("2");
                        }
                }
            });

            t1.start();
            t2.start();
        }

    }
