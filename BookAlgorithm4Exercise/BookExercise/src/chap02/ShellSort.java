package chap02;

/**
 * @ClassName ShellSort
 * @Description 希尔排序
 * @Author iematthew
 * @Date 2020/7/13 11:35
 * @Version 1.0
 **/

/*

































































































































希尔排序是插入排序的一个改进
 */
public class ShellSort {
    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;//h是间隔,h的设置其实不一定要是这样的，取间隔也是一个问题
        while(h < N/3) h = h*3 + 1;
        while (h >= 1){
            for (int i = h; i < N; i++){
                for (int j = i; j >=h && CommonMethod.less(a[j],a[j-h]); j -= h){
                    CommonMethod.exch(a,j,j-h);
                }
            }
            h = h / 3;
        }
    }
}