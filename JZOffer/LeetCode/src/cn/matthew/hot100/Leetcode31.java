package cn.matthew.hot100;

import java.util.Arrays;

/**
 * @ClassName Leetcode31
 * @Description 下一个字典排列
 * @Author iematthew
 * @Date 2020/9/16 15:27
 * @Version 1.0
 **/

/*
算法需要将给定的数字序列重新排列成字典序中下一个更大的排列
如果不存在下一个更大的序列，那么就将数字排列成最小的排列。
必须原地修改，只允许使用额外的常数空间。

1,2,3 -> 1,3,2
3,2,1 -> 1,2,3
1,1,5 -> 1,5,1

思路：
1.需要将后面的大数与前面的小数交换，比如123456的下一个是将末尾的5和6进行交换123465
2.下一个数的增长幅度尽可能的小
    1.在尽可能靠右的低位进行交换，需要从后向前查找
    2.将一个尽可能小的大数和前面的小数进行交换
    3.将大数换到前面之后，后面的数需要进行升序排列

算法：
1.从后向前查找第一个相对升序的元素对(i,j),nums[i]<nums[j],此时nums[j]到nums[end]为降序
2.在降序里面找到第一个满足nums[k] > nums[i]的，
3.交换nums[i]和nums[k]
4.此时nums[j]到nums[end]依然降序，所以大数换到前面，后面的数字需要升序
5.如果步骤1中找不到这样的元素对，那么意味着数组是降序的，那么直接整个数组反着排列

 */
public class Leetcode31 {
    public int[] nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) return nums;

        int len = nums.length;

        for (int i = len - 2; i >= 0; i--) {
            for (int j = len - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    //交换
                    exch(nums, i, j);
                    //升序
                    Arrays.sort(nums, i + 1, nums.length);
                    return nums;
                }
            }
        }
        Arrays.sort(nums);
        return nums;
    }

    public void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
