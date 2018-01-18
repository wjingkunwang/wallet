package com.qiyuezaixian;

/**
 * Created by wjk on 2017/9/8.
 */
public class RevolveArray {
    public static  void reverse(char [] arr, int start, int end){
        int mid = (start + end) / 2;
        for(int s = start, i = 1; i < mid; s++, i++){
            char temp = arr[s];
            arr[s] = arr[end-i];
            arr[end-i] = temp;
        }
    }

    public void useReverse(char [] arr, int len, int m){
        reverse(arr, 0, m);
        reverse(arr, m, len);
        reverse(arr, 0, len);
    }

    public static void main(String[] args) {
        char[] array = new char[]{'a','v','d','f'};
        reverse(array,0,3);
        System.out.println(array);
    }
}
