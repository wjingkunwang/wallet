package core;

/**
 * Created by wjk on 2018/1/10.
 */
public class Mult {

    public static void main(String[] args) {
        int[] a = new int[10];
        a = mult(a,9);
        for(int i = 0;i<a.length;i++){
            System.out.print(a[i]);
        }

    }
    public static int[] mult(int[] a, int key){
        a[a.length - 1] = 9;
        a[a.length - 2] = 8;
        a[a.length - 3] = 7;
        for(int i = a.length-1;i>0;i--){
            a[i]*=key;
        }

        for(int i = a.length-1;i>0;i--){
            a[i-1] += a[i]/10;
            a[i]= a[i]%10;
        }
        return a;
    }
}
