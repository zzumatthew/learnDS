package cn.matthew.jzoffer;

/**
 * @description: 机器人的运动范围
 * @date: 8/9/2020
 * @author: 大帅
 * @version:
 */

/*
题目：
地上有一个m行n列的方格。一个机器人从坐标（0，0）的格子开始移动，
它每次可以向左、右、上、下移动一格，但是不能进入行坐标和列坐标的位数之和大于k的格子。
例如当k=18，机器人能够进入方格（35，37），因为3+5+3+7=18；
但是不能进入（35，38），因为3+5+3+8=19.请问该机器人能够到达多少个格子。

思路：
这个方格也可以看作是m*n的矩阵，同样这个矩阵中除了边界的格子之外，每一个格子都有4个相邻的格子
机器人从坐标（0，0）开始移动，当它准备进入坐标为（i，j）的格子时，首先需要检查坐标的位数和是否满足要求
如果可以进入（i，j）这个格子，则再判断它能否进入4个相邻的格子。所以也是用的回溯法
 */
public class JZ13 {
    public static void main(String[] args) {
        int threshold = 10;
        int rows = 3;
        int columns = 3;
        System.out.println(movingCount(threshold, rows, columns));
    }

    /**
     * 统计机器人能走多少个方格
     *
     * @param threshold 坐标位数和阈值
     * @param rows      方格行树
     * @param columns   方格列数
     * @return 总共可以走的方格数
     */
    public static int movingCount(int threshold, int rows, int columns) {
        if (threshold < 0 || rows <= 0 || columns <= 0)
            return 0;

        boolean[] isVisited = new boolean[rows * columns];

        int count = movingCountCore(threshold, rows, columns, 0, 0, isVisited);

        return count;
    }

    public static int movingCountCore(int threshold, int rows, int columns, int row, int col, boolean[] isVisited) {
        int count = 0;
        if (chech(threshold, rows, columns, row, col, isVisited)) {
            isVisited[row * columns + col] = true;
            count = 1 + movingCountCore(threshold, rows, columns, row - 1, col, isVisited)
                    + movingCountCore(threshold, rows, columns, row + 1, col, isVisited)
                    + movingCountCore(threshold, rows, columns, row, col - 1, isVisited)
                    + movingCountCore(threshold, rows, columns, row, col + 1, isVisited);
        }
        return count;
    }

    /**
     * 判断机器人能否到达指定的格子（检查位数之和）
     *
     * @param threshold 位数之和阈值
     * @param rows      格子行数
     * @param columns   格子列数
     * @param row       当前要判断的格子所在的行
     * @param col       当前要判断的格子所在的列
     * @param isVisited 当前的格子是否已经被访问过
     * @return false不能访问，true可以访问
     */
    public static boolean chech(int threshold, int rows, int columns, int row, int col, boolean[] isVisited) {
        if (row >= 0 && row < rows && col >= 0 && col < columns
                && getDigi(row) + getDigi(col) <= threshold
                && !isVisited[row * columns + col])
            return true;

        return false;
    }

    /**
     * 求一个数字的各个位数的数字之和
     *
     * @param aNum 输入的数字
     * @return 输入的数字的各个位的数字之和
     */
    public static int getDigi(int aNum) {
        int sum = 0;
        while (aNum > 0) {
            sum += aNum % 10;
            aNum /= 10;
        }
        return sum;
    }
}