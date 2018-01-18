package jvm.oom;

import java.io.IOException;

/**
 * 测试static变量内存分配的位置：方法区 or 堆
 * <p>
 * -Xmx10m -Xms10m  -XX:MaxPermSize=3 -XX:PermSize=3m -XX:+PrintGC
 */
public class StaticDemo {
    static byte[] bytes = new byte[1 * 1024 * 1024];

    public static void main(String[] args) throws IOException {
        System.out.println(bytes);
//        System.in.read();
    }

}
