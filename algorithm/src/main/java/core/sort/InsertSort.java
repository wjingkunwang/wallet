package core.sort;

/**
 * 优化使其不是三层循环
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = {2,32,12,45,3,5};
        int[] b =  insert(a);
        for(int i = 0;i<a.length;i++){
            System.out.println(a[i]);
        }


    }

    public static int[] insert (int[] a){
        int len = a.length;
        for(int i = 1;i<len;i++){
            for(int j = 0 ;j<i;j++){
                if(a[j] > a[i]){
                    int temp=a[i];
                    for(int k = i;k>=j;k--){
                        a[k] =a[k-1];
                    }
                    a[j] = temp;
                    break;
                }
            }
        }
        return a;
    }
}
