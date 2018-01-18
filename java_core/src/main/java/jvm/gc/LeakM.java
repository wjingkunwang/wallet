package jvm.gc;

import java.util.Vector;

/**
 * http://www.cnblogs.com/qq78292959/archive/2011/07/25/2116123.html
 *
 * -Xmx10M -Xms10M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/User/wjk/dump
 */
public class LeakM {
    public static void main(String[] args) {
        Vector v = new Vector(10);
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            Object o = new Object();
            v.add(o);
            o = null;
        }
    }
}
