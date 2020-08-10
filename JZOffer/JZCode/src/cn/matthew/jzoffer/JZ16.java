package cn.matthew.jzoffer;

/**
 * @description: 数值的整数次方
 * @date: 8/9/2020
 * @author: 大帅
 * @version:
 */

/*
题目：
实现Math.pow（double base,int exponent），求base的exponent次方。
不得使用现成的方法，同时不需要考虑大数问题。

思路：
根据底数和指数的正负号，分以下几种情况进行讨论
base == 0，exponent == 0，没有意义
base == 0，exponent ！= 0
exponent > 0
exponent < 0

启发：
这道题需要清晰的考虑问题；
底数的正负号和指数的正负号都要考虑到。
 */
public class JZ16 {
    public static void main(String[] args) throws Exception {
        double base = 2;
        int exponent = 5;
        System.out.printf("%.3f的%d次方为%.3f", base, exponent, pow(base, exponent));
    }

    /**
     * 求数值的整数次方
     *
     * @param base     底数
     * @param exponent 整数指数
     * @return 结果
     */
    private static double pow(double base, int exponent) throws Exception {
        double res = 1;
        if (base == 0 && exponent == 0) throw new Exception("0的0次方没有意义！");
        if (base == 0 && exponent != 0) res = 0;
        if (exponent > 0) {
            //指数为正整数
            for (int i = 0; i < exponent; i++) {
                res = res * base;
            }
        } else {
            //指数为负整数
            for (int i = 0; i < abs(exponent); i++) {
                res = res / base;
            }
        }
        return res;
    }

    /**
     * 如果不能用Math.abs，自己实现一下
     *
     * @param num 输入的数
     * @return num的绝对值
     */
    private static int abs(int num) {
        if (num >= 0) {
            return num;
        } else {
            return -num;
        }
    }
}
