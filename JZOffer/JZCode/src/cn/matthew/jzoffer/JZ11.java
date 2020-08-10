package cn.matthew.jzoffer;

import java.util.Arrays;

/**
 * @description: 旋转数组中的最小数字
 * @date: 8/7/2020
 * @author: 大帅
 * @version:
 */

/*
题目：
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
例如，数组｛3，4，5，1，2｝是数组｛1，2，3，4，5｝的一个旋转，该数组的最小值为1

思路：
如果要求在排序的数组或者部分排序的数组中查找一个数字或者统计某个数字出现的次数的时候，
那么都可以尝试用二分查找。
注意到给出的旋转数组是可以看成是两个部分有序的数组;数组的最小值恰好把数组分成了两个部分。

启发：
有序的或者是部分有序的，可以考虑二分法。（所以排序也要会，无序的排序也可以考虑用二分法）
 */
public class JZ11 {
    public static void main(String[] args) throws Exception {
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(Arrays.toString(arr) + "的最小值为" + findMin(arr));
        int[] arr1 = {1, 1, 1, 0, 1};
        System.out.println(Arrays.toString(arr1) + "的最小值为" + findMin(arr1));
    }

    /**
     * 找出旋转数组中的最小值
     *
     * @param arr 输入的旋转数组
     * @return 数组中的最小值
     */
    public static int findMin(int[] arr) throws Exception {
        if (arr == null || arr.length <= 0) throw new Exception("数组不合理！");

        int p1 = 0;//定义第一个指针（借用概念）
        int p2 = arr.length - 1;//定义第二个指针
        int pMid = 0;//定义二分法用到的中间指针
        while (arr[p1] >= arr[p2]) {
            //循环结束的条件就是两个指针指向相邻的位置,且p2所指向的数字就是最小值
            if (p2 - p1 == 1) {
                pMid = p2;
                break;
            }

            pMid = (p1 + p2) / 2;

            //特殊情况：如果p1，pMid，p2所指向的数是一样大，那么只能顺序查找
            if (arr[p1] == arr[pMid] && arr[pMid] == arr[p2])
                return minInOrder(arr, p1, p2);

            //非特殊情况，二分查找
            if (arr[p1] <= arr[pMid]) {
                p1 = pMid;
            } else if (arr[p2] >= arr[pMid]) {
                p2 = pMid;
            }
        }
        return arr[pMid];
    }

    /**
     * 特殊情况下，只能按顺序遍历查找了
     *
     * @param arr 数组
     * @param p1  指针1
     * @param p2  指针2
     * @return 最小值
     */
    public static int minInOrder(int[] arr, int p1, int p2) {
        int result = arr[p1];
        for (int i = p1 + 1; i <= p2; i++) {
            if (result > arr[i])
                result = arr[i];
        }
        return result;
    }
}
