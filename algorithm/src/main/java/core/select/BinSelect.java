package core.select;

/**
 * Created by wjk on 2018/1/10.
 */
public class BinSelect {
    public static void main(String[] args) {
        int[] a = {3,4,6,8,9,10};
        System.out.println(binSelect(a,9));
    }

    public  static  int binSelect(int[] a,int key) {
        int start = 0;
        int end = a.length-1;
        while(end>=start){
            int middle = (start+end)/2;
            if(a[middle] == key){
                return middle;
            }else if(a[middle] > key){
                end = middle-1;
            }else {
                start= middle+1;
            }
        }
        return -1;
    }
}
