package cn.matthew.jzoffer;

import java.util.Arrays;

/**
 * @ClassName JZ21
 * @Description 调整数组顺序使得奇数位于偶数前面
 * @Author iematthew
 * @Date 2020/8/10 16:19
 * @Version 1.0
 **/

/*
题目：
输入一个整数数组，实现一个函数用于调整数组；
使得所有的级数位于数组的前半部分，偶数位于数组的后半部分。

思路：
可以使用两个指针，第一个指针初始化的时候指向数组的第一个元素，这个指针负责往后移动；
第二个指针初始化的时候指向数组的最后一个元素，这个指针只负责往前移动。
如果第一个指针指向的是偶数且第二个指针指向奇数，那么就进行交换。
如果不是的话，两个指针各自移动一位。
 */
public class JZ21 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 5, 7, 11, 20};
        System.out.println(Arrays.toString(reorderOddEven(nums)));
    }

    public static int[] reorderOddEven(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int p1 = 0;//初始化第一个指针
        int p2 = nums.length - 1;//初始化第二个指针
        int temp;//交换中转
        while (p1 < p2) {
            //p1指向的不是偶数，则往后移动1位
            while (p1 < p2 && nums[p1] % 2 != 0) {
                p1++;
            }
            //p2指向的不是奇数，则向前移动1位
            while (p1 < p2 && nums[p2] % 2 == 0) {
                p2--;
            }
            //p1指向偶数，p2指向奇数，交换
            temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
        }
        return nums;
    }
}
