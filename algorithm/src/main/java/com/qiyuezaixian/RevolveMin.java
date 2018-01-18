package com.qiyuezaixian;

/**
 * 假定一个排序数组以某个未知元素为支点做
 * 了旋转，如：原数组0 1 2 4 5 6 7旋转后得到
 * 4 5 6 7 0 1 2。请找出旋转后数组的最小值。
 * 假定数组中没有重复数字
 */
public class RevolveMin {
    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(revolveMin(array));
    }

    public static int revolveMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (high > low) {
            int middle = (high + low) / 2;
            if (arr[middle] > high) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }

        return low;
    }

}
