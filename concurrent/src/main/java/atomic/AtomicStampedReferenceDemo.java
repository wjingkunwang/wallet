package atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 因为AtomicInteger AtomicReference 存在ABA问题，通过加时间戳来处理
 */
public class AtomicStampedReferenceDemo {
    static AtomicStampedReference<Integer> money = new AtomicStampedReference<Integer>(19, 0);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            final int timeStamp = money.getStamp();
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            while (true) {
                                Integer m = money.getReference();
                                if (m < 20) {
                                    if (money.weakCompareAndSet(m, m + 20, timeStamp, timeStamp + 1)) {
                                        System.out.println("余额小于20充值成功，余额" + money.getReference());
                                    }
                                } else {
                                    System.out.println("余额大于20不用充值");
                                    break;
                                }
                            }
                        }
                    }
            ).start();
        }


        //用户线程消费
        for (int i = 0; i < 3; i++) {
            final int timeStamp = money.getStamp();
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            while (true) {
                                Integer m = money.getReference();
                                if (m > 10) {
                                    if (money.weakCompareAndSet(m, m - 10, timeStamp, timeStamp + 1)) {
                                        System.out.println("成功消费10元，余额" + money.getReference());
                                    }
                                } else {
                                    System.out.println("没有足够的金额");
                                    break;
                                }
                            }
                        }
                    }
            ).start();
        }

    }
}
