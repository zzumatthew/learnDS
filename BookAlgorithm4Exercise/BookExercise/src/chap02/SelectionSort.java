package chap02;

/**
 * @ClassName SelectionSort
 * @Description 选择排序
 * @Author iematthew
 * @Date 2020/7/13 11:37
 * @Version 1.0
 **/

/*
选择排序
首先找到数组中最小的元素，与数组中的第一个元素互换位置；
接着从剩下的元素中找到最小的，将之与第二个位置的元素进行位置互换，以此类推。
 */
public class SelectionSort {
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                // a[j] < a[min] 那么min = j
                if (CommonMethod.less(a[j],a[min])){
                    min = j;
                }

            }
            CommonMethod.exch(a,i,min);
        }
    }
}
