package cn.matthew.jzoffer;

/**
 * @ClassName JZ42
 * @Description 连续子数组的最大和
 * @Author iematthew
 * @Date 2020/8/16 18:01
 * @Version 1.0
 **/

/*
题目：
输入一个整型数组，数组里有正数也有负数。
数组中的一个或连续多个整数组成一个子数组。
求所有的子数组的和的最大值。
时间复杂度要求为O(n)

例如输入的数组为{1,-2,3,10,-4,7,2,-5},和最大的子数组为{3,10,-4,7,2}.

思路：
如果数组中只有整数或者只有正数，那么这个问题就不是问题。
所以在有正负混合的时候，遇到负数的时候怎么处理？
剑指里面提供了两种思路：

第一种思路比较容易理解
    1-2 = -1,负的直接舍弃
    前面的舍弃，从3开始
    3+10 = 13
    0 < 13-4 = 9 < 13,把之前的13存起来，可能是最大值
    9+7=16>13，更新最大值
    16+2=18>16，更新最大值
    18-5<15,最大值保留
第二种用的是动态规划（对动态规划还不是很熟悉）
用什么数据结构？
 */
public class JZ42 {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] arr1 = {-10, -8, -2, -4, -6};
        System.out.println(maxSubArray(arr1));
    }

    public static int maxSubArray(int[] arr) {
        if (arr.length == 0) return 0;
        int res = arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (sum < 0)
                sum = arr[i];//和小于0的时候直接舍弃之前的累加，重新开始
            else
                sum += arr[i];

            if (sum > res)
                res = sum;
        }
        return res;
    }
}
