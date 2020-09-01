package cn.matthew.jzoffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName JZ57
 * @Description 和为s的两个数字
 * @Author iematthew
 * @Date 2020/8/31 21:38
 * @Version 1.0
 **/

/*
题目：
输入一个递增的数组和一个数字s，在数组中查找两个数，使得它们的和恰好为s。
如果有多对数字的和等于s，则输出任意一对数字即可。

输入 nums = {2,7,11,5},target = 9
输出{2,7}或者{7,2}

思路：
1.利用HashSet检测
2.双指针
 */
public class JZ57_01 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 5};
        int target = 9;
        System.out.println(twoSum(nums, target));
    }

    //利用HashSet检测：时间和空间都表现不太好
    //如果hash里面包含target-num，那么返回
    //如果hash里面不包含target - num，num加入到hash里面
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return null;

        Set<Integer> hash = new HashSet<>();
        for (int num : nums) {
            if (hash.contains(target - num)) {
                return new int[]{num, target - num};
            }
            hash.add(num);
        }

        return null;
    }

    //双指针检测
    //如果nums[i] + nums[j] = target，return new int[]{nums[i],nums[j]};
    //如果nums[i] + nums[j] > target,j--;
    //如果nums[i] + nums[j] < target,i++;
    public static int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return null;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[]{nums[i], nums[j]};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }

        return null;
    }
}
