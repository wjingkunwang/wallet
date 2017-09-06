package com.qiyuezaixian;

/**
 * Created by wjk on 2017/9/3.
 */
public class MaxSubSum3 {
    private static int max3(int a,int b,int c){
        int temp = Math.max(a, b);
        return Math.max(temp, c);
    }

    private static int maxSumRec(int[] array,int left,int right){


        if (left == right)
            return array[left] > 0 ? array[left] : 0;
        //二分
        int center = (left+right)>>1;//右移位一次，为除法的除以2，但是效率比较高
        int maxLeftSum = maxSumRec(array,left,center);
        int maxRightSum = maxSumRec(array,center+1,right);

        int maxLeftBorderSum = 0, curLeftBorderSum = 0;
        for(int i = center;i >= left; i--){
            curLeftBorderSum += array[i] ;
            if(curLeftBorderSum > maxLeftBorderSum)
                maxLeftBorderSum = curLeftBorderSum;
        }
        int maxRightBorderSum = 0, curRightBorderSum = 0;
        for(int i = center+1; i <= right;i++){
            curRightBorderSum += array[i];
            if(curRightBorderSum > maxRightBorderSum)
                maxRightBorderSum = curRightBorderSum;
        }

        return max3(maxLeftSum,maxRightSum,maxRightBorderSum+maxLeftBorderSum);
    }

    public static int maxSum(int[] array){
        return maxSumRec(array,0,array.length-1);
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = new int[]{4,-3,5,-2,-1,2,6,-2};
        long startTime = System.nanoTime();
        System.out.println("最大子序列和为："+MaxSubSum3.maxSum(array));
        long endTime = System.nanoTime();
        System.out.println("程序耗时为："+(endTime-startTime)+" ns");
    }

}
