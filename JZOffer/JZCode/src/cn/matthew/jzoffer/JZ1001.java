package cn.matthew.jzoffer;

/**
 * @description: 斐波那契数列
 * @date: 8/7/2020
 * @author: 大帅
 * @version:
 */

/*
求斐波那契数列的第n项
写一个函数，输入n，求斐波那契数列的第n项,斐波那契数列的定义如下
f(n) = 0,n=0
f(n) = 1,n=1
f(n) = f(n-1)+f(n-2),n>1

思路：
最直截了当的做法就是直接将函数实现，但是问题是不是最合理的解法。
原因就是f(100)=f(99)+f(98);f(99)=f(98)+f(97);
有一些值是被重复计算的，比如f(98)这样会被算两次；
所以应该从下往上计算，避免重复计算。（斐波那契数列的后面的值实在是太大了）
 */
public class JZ1001 {
    public static void main(String[] args) {
        System.out.println(Fibonacci(50));
    }

    /**
     * 求斐波那契数列的第i项
     *
     * @param n 需要求的斐波那契数列的目标项
     * @return 返回目标项对应的值
     */
    private static long Fibonacci(int n) {
        int[] result = {0, 1};
        if (n < 2) return result[n];
        long fNMinus2 = 0;
        long fNMinus1 = 1;
        long fN = 0;
        for (long i = 2; i < n; ++i) {
            fN = fNMinus2 + fNMinus1;
            fNMinus2 = fNMinus1;
            fNMinus1 = fN;
        }
        return fN;
    }
}
