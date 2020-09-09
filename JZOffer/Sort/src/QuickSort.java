import java.util.Arrays;

/**
 * @description: 快速排序
 * @date: 8/9/2020
 * @author: 大帅
 * @version:
 */
public class QuickSort {
    public int[] sort(int[] sourceArr) {
        //对arr进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        return quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    //快速排序可以定义两个哨兵p1和p2
    //p1从数组的最左边开始动，p1负责寻找比基准值大的数
    //p2从数组的最右边开始动，p2负责寻找比基准值小的数
    //p2的值和p1的值进行交换
    //当p1和p2相遇的时候，p2所在的位置就应该是分界点
    //将p2的位置和基准值位置（left）进行交换
    //此时就可以实现在分界点左边的数都比基准值小，分界点右边的数都比基准值大
    //递归处理左右部分
    private int partition(int[] arr, int left, int right) {
        // 设定基准值
        int bench = arr[left];
        int p1 = left;//第一个哨兵，负责找大于基准值的
        int p2 = right;//第二个哨兵，负责找小于基准值的
        while (p1 != p2) {
            while (arr[p2] >= bench && p1 < p2)
                p2--;
            while (arr[p1] <= bench && p1 < p2)
                p1++;
            if (p1 < p2)
                exch(arr, p1, p2);
        }
        exch(arr, left, p2);//最后需要把相遇点（数组分界点）上的数和基准值的数交换
        //因为每一次都是让p2先动，所以相遇的时候，p2上的值也是不大于基准值的，所以也需要交换
        //返回的p2就是数组的分界点
        return p2;
    }

    //两个位置交换
    public static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
