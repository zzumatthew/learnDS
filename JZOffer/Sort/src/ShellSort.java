/**
 * @description: 希尔排序
 * @date: 8/9/2020
 * @author: 大帅
 * @version:
 */
public class ShellSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;//h为间隔
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
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
