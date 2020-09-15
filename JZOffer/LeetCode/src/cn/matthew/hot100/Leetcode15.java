package cn.matthew.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Leetcode15
 * @Description 三数之和
 * @Author iematthew
 * @Date 2020/9/15 17:09
 * @Version 1.0
 **/

/*
Leetcode HOT100 第15题：请找出数组nums中和为0的三个数

思路：
用三个指针i,l,r
l = i + 1;
r = nums.length - 1;
首先需要将nums排序；
总体思路就是sum = nums[i] + nums[j] + nums[r],如果sum = 0记录，sum > 0说明太大，r--，sum < 0说明太小l++;
nums[l]和nums[r]遇到重复的要避免
 */
public class Leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        int len = nums.length;
        int sum = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0)
                return res;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    //出现重复的,比如[-1,1,1,2]算[-1,1,2]算了一次，nums[2]位置的1就没有必要算了，下面的while语句同理
                    while (l < r && nums[l + 1] == nums[l])
                        l++;
                    while (l < r && nums[r - 1] == nums[r])
                        r--;
                    l++;
                    r--;
                } else if (sum > 0) {
                    //sum太大，由于nums是从大到小排序的，r--
                    r--;
                } else {
                    //sum太小，l++
                    l++;
                }
            }
        }

        return res;
    }
}
