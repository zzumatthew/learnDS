package cn.matthew.jzoffer;

/**
 * @description: 青蛙跳台阶问题
 * @date: 8/7/2020
 * @author: 大帅
 * @version:
 */

/*
题目：
一只青蛙一次可以跳上1级台阶，也可以跳上两级台阶。求该青蛙一个n级台阶一共有多少种跳法。

思路：
n = 1，1种
n = 2，2种
n = 3，3种（1*3，1+2，2+1）
n = 4，5种（1*4，1+1+2，1+2+1，2+1+1，2+2）
n = 5，8种（1*5，1+1+1+2，1+1+2+1，1+2+1+1，2+1+1+1，1+2+2，2+1+2，2+2+1）
找规律就是一个斐波那契数列
f(1) = 1;
f(2) = 2;
f(n) = f(n-1) + f(n-2);

启发：
遇到这种问题肯定有规律，那么剩下的问题就是能不能通过几个例子推导出关系式。
 */
public class JZ1002 {
    public static void main(String[] args) {
        System.out.println(leapFrog(5));
    }

    /**
     * 青蛙一共有几种跳法
     *
     * @param n 跳的台阶数
     * @return 跳的方法数
     */
    public static long leapFrog(int n) {
        int[] result = {1, 2};
        if (n < 3) return result[n - 1];
        long fNMinus2 = 1;
        long fNMinus1 = 2;
        long fN = 0;
        for (int i = 3; i <= n; ++i) {
            fN = fNMinus1 + fNMinus2;
            fNMinus2 = fNMinus1;
            fNMinus1 = fN;
        }
        return fN;
    }
}
