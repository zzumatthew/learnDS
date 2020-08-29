package cn.matthew.jzoffer;

import java.util.Arrays;
import java.util.Objects;

/**
 * @ClassName JZ51
 * @Description 数组中的逆序对
 * @Author iematthew
 * @Date 2020/8/27 21:03
 * @Version 1.0
 **/

/*
题目：
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
输入一个数组，求出这个数组中的逆序对的总数。
例如输入[7，5，6，4] 输出5

思路：
暴力求解不可取，遍历数组中的每一个数，与后面的数进行比较。
然而这样的复杂度为O(n^2)，因为要进行两层循环，测试的时候会超时。

对于[1,2,3,4]这个数组，逆序对一看就是0；
对于[4,3,2,1]这个数组，逆序对就是3+2+1=6；
所以对于部分有序数组，可以很快的判断逆序对。

所以就是归并排序的翻版，只不过是在其中一个判断语句中求逆序对。
以下就是一个标准的归并排序。
 */
public class JZ51 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(reversePairs(nums));
    }

    //记录结果的全局变量
    static int res = 0;

    public static int reversePairs(int[] nums) {
        //没有元素或者只有一个元素，直接返回0
        if (nums.length < 2) return 0;
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, right, mid + 1);
        }
    }

    public static void merge(int[] nums, int left, int right, int mid) {
        //左边有序数组的长度
        int lenL = mid - left;
        //右边有序数组的长度
        int lenR = right - mid + 1;
        //定义一个数组存储左边有序数组
        int[] numsL = Arrays.copyOfRange(nums, left, mid);
        //定义一个数组存储右边有序数组
        int[] numsR = Arrays.copyOfRange(nums, mid, right + 1);
        //遍历左数组指针
        int lp = 0;
        //遍历右数组指针
        int rp = 0;
        //合并元素在copy数组中的指针
        int cp = left;

        while (lp < lenL && rp < lenR) {
            if (numsL[lp] <= numsR[rp]) {
                nums[cp++] = numsL[lp++];
            } else {
                nums[cp++] = numsR[rp++];
                //这里有逆序对,此时左边还没有放进copy数组中的元素个数就是当前下的逆序对
                res += (lenL - lp);
            }
        }

        while (lp < lenL) {
            nums[cp++] = numsL[lp++];
        }

        while (rp < lenR) {
            nums[cp++] = numsR[rp++];
        }
    }
}
