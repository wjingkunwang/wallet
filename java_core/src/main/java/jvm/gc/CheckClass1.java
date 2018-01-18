package jvm.gc;

import java.util.HashMap;

/**
 * -Xmx512M -Xms512M -XX:+UseSerialGC -XX:+PrintGCDetails -Xmn1m -XX:PretenureSizeThreshold=50 -XX:MaxTenuringThreshold=1
 */
public class CheckClass1 extends Thread {
    HashMap hashMap = new HashMap();

    @Override
    public void run() {
        while (true) {
            if (hashMap.size() * 512 / 1024 / 1024 > 450) {
                System.out.println("准备清理" + hashMap.size());
                hashMap.clear();
            }

//            for (int i = 0; i < 1024; i++) {
                hashMap.put(System.nanoTime(), new Byte[51200000]);
            }
        }

    public static void main(String[] args) {
        CheckClass1 checkClass1 = new CheckClass1();
        checkClass1.start();
    }
}
