import java.lang.annotation.Target;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wjk on 2018/1/16.
 */
public class Solution {
    public static void main(String[] args) {
        int[] a =  {2, 7, 11, 15};
        int target = 9 ;
        int[] b =twoSum(a,target);
        System.out.println();
    }
    public  static  int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            Integer index=map.get(target-nums[i]);
            if(index==null){
                map.put(nums[i],i);
            }else{
                return new int[]{i,index};
            }
        }
        return new int[]{0,0};
    }
}