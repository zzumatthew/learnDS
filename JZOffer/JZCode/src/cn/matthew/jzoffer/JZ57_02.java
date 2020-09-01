package cn.matthew.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName JZ57_02
 * @Description 和为s的连续正数序列
 * @Author iematthew
 * @Date 2020/9/01 15:23
 * @Version 1.0
 **/

/*
题目：
输入一个正数s，打印所有的和为s的连续正数序列（至少含有两个数）。
例如输入15，由于1+2+3+4+5=4+5+6=7+8，所以打印出3个连续序列1~5，4~6，7~8

思路：
还是利用前面题目的双指针的思路。
用两个指针small和big分别代表序列的最大值和最小值。令small从1开始，big从2开始。
当从small到big的序列的和小于s时，增加big，使序列包含更多数字；（记得更新序列之和）
当从small到big的序列的和大于s时，增加small，使序列去掉较小的数字；（记得更新序列之和）
当从small到big的序列的和等于s时，此时得到一个满足题目要求的序列，输出，然后继续将small增大，往后面找新的序列。
序列最少两个数字，因此，当small到了s/2时，就可以结束判断了

 */
public class JZ57_02 {
    public static void main(String[] args) {
        int target = 10;
        System.out.println(Arrays.deepToString(findContinuousSeq(10)));
    }

    public static int[][] findContinuousSeq(int target) {
        if (target < 3) return null;

        int small = 1;
        int big = 2;
        int mid = (1 + target) >> 1;
        int curSum = small + big;
        List<int[]> list = new ArrayList<>();

        //small到了target/2的时候就应该结束（因为至少要两个数）
        while (small < mid) {

            if (curSum == target) {
                list.add(getContinuousSeq(small, big));
            }

            while (curSum > target && small < mid) {
                curSum -= small;
                small++;

                if (curSum == target) {
                    list.add(getContinuousSeq(small, big));
                }
            }

            big++;
            curSum += big;
        }

        //List转int[][]
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    //记录结果到一个一维数组
    public static int[] getContinuousSeq(int small, int big) {
        int[] tmp = new int[big - small + 1];
        int p = 0;
        for (int i = small; i <= big; i++) {
            tmp[p++] = i;
        }
        return tmp;
    }

}
