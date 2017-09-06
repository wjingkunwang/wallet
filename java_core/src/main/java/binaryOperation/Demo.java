package binaryOperation;

/**
 * 关于二进制的为运算
 *
 * (1).Java中没有无符号数, 换言之, Java中的数都是有符号的;
 * (2).二进制的最高位是符号位, 0表示正数, 1表示负数;
 * (3).正数的原码, 反码, 补码都一样;
 * (4).负数的反码=它的原码符号位不变, 其他位取反;
 * (5).负数的补码=它的反码+1;
 * (6).0的反码, 补码都是0;
 * (7).在计算机运算的时候, 都是以补码的方式来运算的.
 */
public class Demo {
    public static void main(String[] args) {

        /**
         * 位运算
         * 与  &
         * 或  |
         * 异或 ^ （二位 一个为0一个为1 结果为1）
         * 取反 ~
         */
        System.out.println(~2);
        System.out.println(2&3);
        System.out.println(2|3);
        System.out.println(~-5);
        System.out.println(13&7);
        System.out.println(5|4);
        System.out.println(-3^3);

        /**
         * 移位运算
         * 算数右移>> 低位溢出，符号位不变，并用符号位补溢出位
         * 算数左移<< 符号位不变，低位补0
         * 逻辑右移>>> 低位溢出，高位补0
         */
        System.out.println(1 >> 2);
        System.out.println(-1 >> 2);//注意运算的时候都是补码，补码->原码（取反，加1）
        System.out.println(1 << 2);
        System.out.println(-1 << 2);
        System.out.println(3 >>> 2);
    }
}
