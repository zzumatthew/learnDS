package cn.matthew.jzoffer;

import java.util.Arrays;

/**
 * @ClassName JZ60
 * @Description n个骰子的点数
 * @Author iematthew
 * @Date 2020/9/02 11:24
 * @Version 1.0
 **/

/*
题目：
把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。
输入n，打印出s的所有可能的值出现的概率。
你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。

思路：
当只有1个骰子的时候，s = {1,2,3,4,5,6}，概率计算就是和出现的次数比上总的组合数。
当有2个骰子的时候，s = {2,3,4,...,12},这时候的概率的计算就是
一共有36种情况，s = 2只能一种组合，s = 3有两种组合...
当有3个骰子的时候，s = {3,4,...,18}
s = 8出现的次数可以由只有2个骰子出现的次数推算，第3个骰子点数范围是1~6
那么三个骰子和为8的时候，2个骰子出现的点数可以为7,6,5,4,3,2
记dp[i][j]表示i个骰子的和为j出现的次数，那么dp[i][j] = SUM(dp[i-1][j-k]),k从1到6


还是用了动态规划。
 */
public class JZ60 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(2)));
    }

    public static double[] twoSum(int n) {
        //n个骰子最大点数和为6n,最小点数和为n
        int[][] dp = new int[n][6 * n];
        //存放结果，n个骰子一共有5n+1种情况(6n-n+1)
        double[] res = new double[5 * n + 1];
        //初始条件，只有一个骰子的时候，每种点数和都只能出现1次
        for (int i = 0; i < 6; i++) {
            dp[0][i] = 1;
        }
        //根据分析出来的规律
        //第一层for骰子的个数（从0开始）
        for (int i = 0; i < n; i++) {
            //第二层for骰子点数和
            for (int j = i; j < 6 * n; j++) {
                //记dp[i][j]表示i个骰子的和为j出现的次数，
                //那么dp[i][j] = SUM(dp[i-1][j-k]),k从1到6
                for (int k = 1; k <= 6; k++) {
                    if (i - 1 >= 0 && j - k >= 0) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }

        double c = Math.pow(6.0, n);//n个骰子一共有6^n种组合情况

        for (int i = 0; i < res.length; i++) {
            res[i] = dp[n - 1][i + n - 1] / c;//求概率
        }

        return res;
    }
}
