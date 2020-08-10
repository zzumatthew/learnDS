package cn.matthew.jzoffer;

import java.util.ArrayList;

/**
 * @description: 数组中重复的数字
 * @date: 8/4/2020
 * @author: 大帅
 * @version:
 */

/*
提供的算法思路：利用好数组的下标
把数组重新排列。
从头到尾依次扫描这个数组中的每个数字，当扫描到下标为i的数字时，首先比较这个数字（用m表示）是不是等于i
如果是，那么接着扫描下一个数字；如果不是，则再拿它和第m个数字进行比较
如果和第m个数字相等，那么就找到了一个重复的数字；如果不等，就把第i个数字和第m个数字交换；
直到找到一个重复的数字
 */
public class JZ0301 {
    public static void main(String[] args) throws Exception {
        int[] origin = {2, 3, 2, 1};//测试用例
        final int repeatNum = findRepeatNum(origin);
        System.out.println("数组中重复的数字为" + repeatNum);

    }

    private static int findRepeatNum(int[] nums) throws Exception {
        //输入的不合法1：数组为空或者数组的长度<=0
        if (nums == null || nums.length <= 0) throw new Exception("输入的数组不合法！");
        //输入的不合法2：数组中的数字小于0或者超过了数组的长度（要求在0-（n-1）之间）
        for (int num : nums) {
            if (num < 0 || num > nums.length) throw new Exception("数组中有数字不合法！");
        }
        //合法的时候进入判断
        for (int i = 0; i < nums.length; i++) {
            //首先比较第i个数字（用m表示）是不是等于i,不是的话进行处理，是的话继续扫描下一个
            if (nums[i] != i) {
                //第m个数字和第i个数字相等，那么就找到了一个重复的数字
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                //第m个数字和第i个数字并不相等，那么就进行交换
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = temp;
            }else {
                i++;
            }
        }
        System.out.println("数组中没有重复的数字！");
        return -1;
    }
}
