package com.qiyuezaixian;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 给定一个整数数组，找到和为零的子数组。你的代码应该返回满足要求的子数组的起始位置和结束位置
 * 给出 [-3, 1, 2, -3, 4]，返回[0, 2]或者 [1, 3]
 * <p>
 * 将数组从第一位依次相加，记录每次的结果，如果map里面没有，就加入map里，如果有，就证明前面肯定有为0的子数组，才会出现一样的和。
 */
public class ZeroArray {
    public static ArrayList<Integer> subarraySum(int[] nums) {
        int len = nums.length;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                ans.add(map.get(sum) + 1);
                ans.add(i);
                return ans;
            }
            map.put(sum, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-3, 1, 2, -3, 4};
        System.out.println(subarraySum(array).toString());

    }


}
