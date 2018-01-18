package core.sort;

/**
 * Created by wjk on 2018/1/16.
 */
public class Quick {

    public static void main(String[] args) {
        int[] a = {2, 12, 3, 34, 4, 7, 8};
        int[] b = sort(a, 0, 6);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

    }

    static int[] sort(int[] a, int s, int e) {
        if (s < e) {
            int f = quick(a, s, e);
            sort(a, s, f-1);
            sort(a, f+1, e);
        }
        return a;
    }

    static int quick(int[] a, int s, int e) {
        int temp = a[s];
        while (s<e) {
            while (s < e && a[e] > temp) {
                e--;
            }
            a[s] = a[e];
            while (s < e && a[s] < temp) {
                s++;
            }
            a[e] = a[s];
        }
        a[e] = temp;
        return e;
    }

}
