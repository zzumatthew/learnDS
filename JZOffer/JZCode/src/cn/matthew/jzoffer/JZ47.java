package cn.matthew.jzoffer;

/**
 * @ClassName JZ47
 * @Description 礼物的最大价值
 * @Author iematthew
 * @Date 2020/8/24 23:43
 * @Version 1.0
 **/

/*
题目：
在一个m*n的棋盘的每一格都放一个礼物，每个礼物都有一定的价值。
你可以从棋盘的左上角开始拿礼物，并每次向左或者向下移动一格，直到达到棋盘的右下角。
给定一个棋盘以及上面的礼物，请计算你能最大拿到多少价值的礼物。

这道题很明显符合动态规划题目的特点，即求最值的问题。
1.设计状态
    先定义一个函数f(i,j)来表示到达(i,j)这个格子时获得的最大价值的礼物
2.状态转移方程
    f(i,j) = max(f(i,j-1),f(i-1,j)) + gift[i,j]
3.初始条件和边界条件
    f(0,0) = gift[0,0]
4.计算顺序
    由状态转移方程可以看出，为了避免重复计算，应该先计算小的再计算大的，从小往大算
 */
public class JZ47 {
    public static void main(String[] args) {
        //方法已通过leetcode的测试
    }

    public static int maxValue(int[][] gift) {
        //设计状态
        int row = gift.length;
        int column = gift[0].length;
        int[][] f = new int[row + 1][column + 1];
        //初始条件不需要手动设置，计算顺序是由小到大
        for (int i = 1; i <= row; ++i) {
            for (int j = 1; j <= column; ++j) {
                f[i][j] = Math.max(f[i][j - 1], f[i - 1][j]) + gift[i][j];
            }
        }
        return f[row][column];
    }
}
