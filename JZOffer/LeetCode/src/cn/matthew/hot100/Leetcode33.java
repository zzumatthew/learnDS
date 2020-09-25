package cn.matthew.hot100;

/**
 * @ClassName Leetcode33
 * @Description 旋转数组中的数字
 * @Author iematthew
 * @Date 2020/9/24 19:38
 * @Version 1.0
 **/


/*
剑指11：旋转数组，双指针
 */
public class Leetcode33 {
    public int search(int[] nums, int target) {
        int p1 = 0;
        int p2 = nums.length - 1;
        int mid = p1;

        while (p1 <= p2) {
            mid = (p1 + p2) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < nums[p2]) {
                //在右边找
                if (nums[mid] < target && target <= nums[p2]) {
                    p1 = mid + 1;
                } else {
                    p2 = mid - 1;
                }
            } else {
                //往左边找
                if (nums[p1] <= target && target < nums[mid]) {
                    p2 = mid - 1;
                } else {
                    p1 = mid + 1;
                }
            }
        }

        return -1;
    }
}
