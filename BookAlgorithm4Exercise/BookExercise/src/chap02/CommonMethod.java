package chap02;


/**
 * @ClassName CommonMethod
 * @Description 公用方法
 * @Author iematthew
 * @Date 2020/7/13 11:36
 * @Version 1.0
 **/

/*
排序算法中一些公用的方法
 */
public class CommonMethod {
    /**
     * 判断两个元素的大小
     * @param a 第一个元素
     * @param b 第二个元素
     * @return true就是前者小于后者
     */
    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    /**
     * 交换数组中的两个元素
     * @param a 输入的数组
     * @param i 需要交换的第一个元素
     * @param j 需要交换的第二个元素
     */
    public static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
