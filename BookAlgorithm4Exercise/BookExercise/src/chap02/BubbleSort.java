package chap02;

/**
 * @ClassName BubbleSort
 * @Description 冒泡排序
 * @Author iematthew
 * @Date 2020/7/13 17:30
 * @Version 1.0
 **/

/*
每次都是从第一个和第二个开始邻居两两比较，大的自动往后排。
效率不好，时间复杂度到了O(N^2)
 */
public class BubbleSort {
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N - i; j++ ){
                if (CommonMethod.less(a[j+1],a[j])){
                    CommonMethod.exch(a,j,j+1);
                }
            }
        }
    }
}
