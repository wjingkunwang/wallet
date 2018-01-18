package jvm.oom;

import java.io.IOException;

/**
 * 栈上分配
 *
 * -Xmx2m -Xms2m  -XX:-DoEscapeAnalysis -XX:+PrintGC
 */
public class OnStackDemo {
    public static void alloc(){
        byte[] a = new byte[8];
        a[0] = 1;
    }

    public static void main(String[] args) throws IOException {
        for(int i =0;i<1000000000;i++){
            alloc();
        }
    }
}
