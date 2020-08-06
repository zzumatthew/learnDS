package chap02;

/**
 * @ClassName InsertionSort
 * @Description TODO
 * @Author iematthew
 * @Date 2020/7/13 11:35
 * @Version 1.0
 **/

/*
插入排序
插入排序是指在待排序的元素中，假设前面n-1(其中n>=2)个数已经是排好顺序的，现将第n个数插到前面已经排好的序列中
然后找到合适自己的位置，使得插入第n个数的这个序列也是排好顺序的。（有一点像打扑克牌的时候理牌）。
这个算法适合小规模的数组，因为元素只能一点点的从数组的一端排到另外一端，数组太大的话比较费时间。
 */
public class InsertionSort {
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N; i++) {
           for (int j = i; j > 0&& CommonMethod.less(a[j],a[j-1]); j--){
               CommonMethod.exch(a,j,j-1);
           }
        }
    }
}
