package cn.matthew.jzoffer;

/**
 * @ClassName JZ53_02
 * @Description 0~n-1中缺失的数字
 * @Author iematthew
 * @Date 2020/8/30 18:22
 * @Version 1.0
 **/

/*
题目：
一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在0~n-1的范围。
在0~n-1的范围内的n个数字中有且只有一个数字不在数组中，请找出这个数字。

例如输入[0,1,3] 输出2

思路：
按道理来说如果不缺失的话，那么数字和下标就是一一对应的。
那么现在缺一个数字，那么有一部分数字的下标对不上。
用二分查找的思想：
1.如果mid == nums[mid]，那么下一轮找右边；
2.如果mid != nums[mid] && mid - 1 == nums[mid-1],那么mid就是缺失的数字；
3.如果mid != nums[mid] && mid - 1 != nums[mid-1],那么下一轮找左边。

所以有序数组就是应该想到二分查找！
 */
public class JZ53_02 {
    //方法已通过测试
    public int missingNumber(int[] nums) {
        //处理异常情况
        if (nums == null || nums.length <= 0) return -1;
        //简单处理[!0,...]这种简单情况
        if (nums[0] != 0) return 0;
        //二分查找处理一般情况
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == mid) {
                low = mid + 1;
            } else if (nums[mid] != mid && nums[mid - 1] != mid - 1) {
                high = mid - 1;
            } else if (nums[mid] != mid && nums[mid - 1] == mid - 1) {
                return mid;
            }
        }

        if (low == nums.length)
            return nums.length;

        return -1;
    }
}
