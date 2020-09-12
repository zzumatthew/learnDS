package cn.matthew.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Leetcode01
 * @Description TODO
 * @Author iematthew
 * @Date 2020/9/12 21:43
 * @Version 1.0
 **/

/*
给定一个整数数组 nums和一个目标值 target，
请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode01 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        //Key代表数组中出现的数字，Value代表数字出现的下标
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hmap.containsKey(target - nums[i])) {
                res[0] = hmap.get(target - nums[i]);
                res[1] = i;
            }

            hmap.put(nums[i], i);
        }

        return res;
    }
}
