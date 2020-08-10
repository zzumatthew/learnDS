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

    private int partition(int[] arr, int left, int right) {
        // 设定基准值
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                exch(arr, i, index);
                index++;
            }
        }
        exch(arr, pivot, index - 1);
        return index - 1;
    }

    //两个位置交换
    public static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
