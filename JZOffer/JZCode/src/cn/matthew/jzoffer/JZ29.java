package cn.matthew.jzoffer;

import java.util.Arrays;

/**
 * @ClassName JZ29
 * @Description 顺时针打印矩阵
 * @Author iematthew
 * @Date 2020/8/12 09:40
 * @Version 1.0
 **/

/*
题目：
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

思路：
可以将矩阵看成若干层。
首先打印最外层，其次打印次外层，依次类推。
定义矩阵的第k层是到最近边界距离为k的所有顶点。
{[1,1,1,1,1,1,1],
 [1,2,2,2,2,2,1],
 [1,2,3,3,3,2,1],
 [1,2,2,2,2,2,1],
 [1,1,1,1,1,1,1]}

对于每一层，从左上方开始以顺时针的顺序遍历所有的元素。
第一层从(0,0)开始，第二层从(1,1)开始；
从前层的左上角坐标为(start,start)的开始，顺时针打印每一层。
如果把打印每一层抽象成方法。那么问题来了，给定的矩阵到底可以打印多少次？
剑指里面给的规律是 rows > start *2 && columns > start * 2就可以打印
对于3*3矩阵，最后一个为(1,1)，对于4*4，最后一层起始点也是(1,1)
对于5*5，最后一层起始点为(2,2)，对于6*6，最后一层起始点也是(2,2)

对于每一层打印
第一步：打印最上行
第二步：打印最右列
第三步：打印最下行
第四步：打印最左列

 */
public class JZ29 {
    public static void main(String[] args) {
        int[][] nums = {{1, 1, 1, 1, 1, 1, 1},
                {1, 2, 2, 2, 2, 2, 1},
                {1, 2, 3, 3, 3, 2, 1},
                {1, 2, 2, 2, 2, 2, 1},
                {1, 1, 1, 1, 1, 1, 1}};
        printMatrixClockwisely(nums);
    }

    //顺时针打印整个矩阵的方法
    public static void printMatrixClockwisely(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int index = 0;
        int left = 0;
        int right = columns - 1;
        int top = 0;
        int bottom = rows - 1;

        while (left <= right && top <= bottom) {
            for (int col = left; col <= right; col++) {
                order[index++] = matrix[top][col];
            }
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }
            //严格小于，是怕出现只有一行或者只有一列的情况
            if (left < right && top < bottom) {
                for (int col = right - 1; col > left; col--) {
                    order[index++] = matrix[bottom][col];
                }
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }

        System.out.println(Arrays.toString(order));
    }


}
