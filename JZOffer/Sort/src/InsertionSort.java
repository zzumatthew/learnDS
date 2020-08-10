/**
 * @description: 插入排序
 * @date: 8/9/2020
 * @author: 大帅
 * @version:
 */
public class InsertionSort {
    //将数组a按照升序排列
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);//如果出后面一个比前面一个小，那么就进行交换
            }
        }
    }

    //比大小
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    //两个位置交换
    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
