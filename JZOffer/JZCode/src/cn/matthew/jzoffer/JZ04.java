package cn.matthew.jzoffer;

/**
 * @description: 二维数组中的查找
 * @date: 8/6/2020
 * @author: 大帅
 * @version:
 */

/*
题目：在一个二维数组中，每一行都按照从左到右递增的顺序排列，每一列都按照从上都下递增的顺序排列
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否有这个整数。

输入：
1 2 8 9
2 4 9 12
4 7 10 13
6 8 11 15
查找数字7：true
查找数字5：false

思路：
不要暴力循环求解！
将二维数组画成一个矩形，给出的二维数组是已经排好序的。
在上述二维数组中查找7的步骤：
1.首先选取数组右上角的数字；
2.如果这个数字等于要查找的数字，那么查找结束；
3.如果这个数字比要查找的数字大，那么就可以删除这一列；
4.如果这个数字比要查找的数字小，那么就可以删除这一行；
5.查找的结果true或者false。
 */
public class JZ04 {
    public static void main(String[] args) {
        int[][] origin = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int k = 3;
        boolean res = findNum(origin,k);
        System.out.println("二维数组中是否含有数字" + k + "?  \n" + res);
    }

    /**
     *
     * @param origin 输入的二维数组
     * @param k 待查找的数
     * @return true表示数组中含有待查找的数，false表示不含有要查找的数
     */
    private static boolean findNum(int[][] origin, int k) {
        boolean flag = false;//flag记录结果
        int rows = origin.length;//二维数组的行
        int columns = origin[0].length;//二维数组的列
        //输入的数组需要满足条件：不能为空，行或者列不能小于0
        if (origin != null && rows > 0 && columns > 0){
            int row = 0;
            int column = columns - 1;
            //row从最小开始，column从最大开始（0行3列，所有的起始都从0开始）
            while (row < rows && column >0){
                //取出数组中的右上角的数字
                if (origin[row][column] == k){
                    //取出来的数字与待查找的数字相等,查找结束，break
                    flag = true;
                    break;
                }else if (origin[row][column] > k){
                    //取出来的数字比待查找的数字大，删除掉这一列，行从最大开始，所以column--
                    column--;
                }else {
                    //取出来的数字比待查找的数字小，删除掉这一行，列从最小开始，所以row++
                    row++;
                }
            }

        }
        return flag;//跑完了flag还没有改，那么就是数组中不存在需要查找的数
    }
}
