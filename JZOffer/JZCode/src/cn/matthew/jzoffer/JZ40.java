package cn.matthew.jzoffer;

import java.util.Arrays;

/**
 * @ClassName JZ40
 * @Description 最小的K个数
 * @Author iematthew
 * @Date 2020/8/15 18:50
 * @Version 1.0
 **/

/*
题目：
输入n个整数，找出其中最小的k个数。
例如，输入4，5，1，6，2，7，3，8这8个数，则最小的4个数字是1，2，3，4.

思路：
常规做法就是把输入的k个数字进行排序，然后取需要的数字，此时时间复杂度为O(nlgn);
其实topK的问题不需要对整个数组进行排序，只需要找到基准值，就可以知道哪些数大哪些数小。
所以可以用快速排序的思想来做，因为快速排序就是用基准值来比大小，两两数字进行位置交换。
首先将数组快速排序，获取到排序后基准值的位置j；
如果j = k，那刚好左边就是topK了；
如果j > k，那就要快排基准值左边部分；否则，快排基准值右边部分。

 */
public class JZ40 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(Arrays.toString(getLeastNums(nums, 4)));
    }

    public static int[] getLeastNums(int[] nums, int k) {
        if (k == 0 || nums.length == 0)
            return new int[]{};
        return quickSearch(nums, 0, nums.length - 1, k - 1);
    }

    public static int[] quickSearch(int[] nums, int lo, int hi, int k) {
        int j = partition(nums, lo, hi);
        if (j == k)
            return Arrays.copyOf(nums, j + 1);
        return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
    }

    public static int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v) ;
            while (--j >= lo && nums[j] > v) ;
            if (i >= j)
                break;
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }
}