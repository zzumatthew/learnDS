/**
 * @description: 选择排序
 * @date: 8/9/2020
 * @author: 大帅
 * @version:
 */
public class SelectionSort {
    //将数组a按照升序排列
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }

    //两个对象做大小比较
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
