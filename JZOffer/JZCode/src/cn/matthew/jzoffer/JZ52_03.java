package cn.matthew.jzoffer;

/**
 * @ClassName JZ52_03
 * @Description 数组中数值和下标相等的元素
 * @Author iematthew
 * @Date 2020/8/30 23:04
 * @Version 1.0
 **/

/*
题目：
假设一个单调递增的数组里的每一个元素都是整数并且是唯一的。
请编写一个函数，找出数组中任意一个数值等于其下标的元素。

例如在数组{-3,-1,1,3,5},数字3和它的下标相等。

思路：
最直观的思路就是从头到位扫描数组，找到 i == nums[i]的时候 return i；
时间复杂度为O(n)。现在数组还是有序的，依旧要想到二分。

这个数字前面的数: 数字小于下标，往右找；
这个数字后面的数：数字大于下标，往左找；

今天写了不少二分法。
 */
public class JZ52_03 {
    public static void main(String[] args) {
        int[] nums = {-3, -1, 1, 3, 5};
        int res = getNumAsIndex(nums);
        System.out.println(res);
    }

    private static int getNumAsIndex(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < mid) {
                low = mid + 1;
            } else if (nums[mid] > mid) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;//实际上不应该用-1做返回值，因为数组中真的有-1
    }
}
