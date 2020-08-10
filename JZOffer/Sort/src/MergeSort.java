import java.util.Arrays;

/**
 * @description: 归并排序
 * @date: 8/9/2020
 * @author: 大帅
 * @version:
 */
public class MergeSort {
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        if (arr.length < 2) return arr;//递归的终止条件
        int middle = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        //上述代码负责将数组分裂
        return merge(sort(left), sort(right));//这里用的是递归，merge调用sort，然后sort继续调用merge，“递”到元素的个数为1，不再继续分，那么“归”。
    }

    protected int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;

        //子数组中都有元素的时候，两个子数组的第一个元素始终是小的先接在result后面，然后该子数组就要把这个元素移出，通过复制数组的方法
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];//把小的数加在result后面
                left = Arrays.copyOfRange(left, 1, left.length);//把接在result的数从原先的数组中移出
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        //如果原始数组并不能分成长度一样的子数组，那么势必有一个子数组会多出元素，很明显这个元素是要直接接在result数组的后面
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }
}
