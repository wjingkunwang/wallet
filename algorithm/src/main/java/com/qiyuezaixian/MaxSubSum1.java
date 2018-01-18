package com.qiyuezaixian;

/**
 * 采用动态规划
 */
public class MaxSubSum1 {

    public static int maxSum(int[] arr) {
        int sum = arr[0];
        int length = arr.length;
        for (int i = 1; i < length - 1; i++) {
            if (sum > 0) {
                sum = sum + arr[i];
            } else {
                sum = arr[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(maxSum(array));
    }

}
