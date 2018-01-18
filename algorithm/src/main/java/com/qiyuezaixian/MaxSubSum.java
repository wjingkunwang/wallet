package com.qiyuezaixian;

/**
 * 最大连续子数组
 * 给定一个数组A[0,…,n-1]，求A的连续子数
 * 组，使得该子数组的和最大。
 * 例如
 * 数组： 1, -2, 3, 10, -4, 7, 2, -5，
 * 最大子数组：3, 10, -4, 7, 2
 *
 * 方法一：分支法，最大连续子数组出现的位置： 左边、右边，中间位置（递归处理）
 *
 */
public class MaxSubSum {
    private static int max3(int a, int b, int c) {
        int temp = Math.max(a, b);
        return Math.max(temp, c);
    }

    private static int maxSumRec(int[] array, int left, int right) {


        if (left == right)
            return array[left] > 0 ? array[left] : 0;
        //二分
        int center = (left + right) >> 1;//右移位一次，为除法的除以2，但是效率比较高
        int maxLeftSum = maxSumRec(array, left, center);
        int maxRightSum = maxSumRec(array, center + 1, right);

        int maxLeftBorderSum = 0, curLeftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            curLeftBorderSum += array[i];
            if (curLeftBorderSum > maxLeftBorderSum)
                maxLeftBorderSum = curLeftBorderSum;
        }
        int maxRightBorderSum = 0, curRightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            curRightBorderSum += array[i];
            if (curRightBorderSum > maxRightBorderSum)
                maxRightBorderSum = curRightBorderSum;
        }

        return max3(maxLeftSum, maxRightSum, maxRightBorderSum + maxLeftBorderSum);
    }

    public static int maxSum(int[] array) {
        return maxSumRec(array, 0, array.length - 1);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        long startTime = System.nanoTime();
        System.out.println("最大子序列和为：" + MaxSubSum.maxSum(array));
        long endTime = System.nanoTime();
        System.out.println("程序耗时为：" + (endTime - startTime) + " ns");
    }

}
