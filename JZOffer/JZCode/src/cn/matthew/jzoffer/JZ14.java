package cn.matthew.jzoffer;

/**
 * @description: 剪绳子 - 动态规划
 * @date: 8/9/2020
 * @author: 大帅
 * @version:
 */

/*
题目：
给你一根长度为n的绳子，请把绳子剪成m段（m，n都是整数，n>1且m>1），
每段绳子的长度记为k[1],k[2],...请问k[1]*...k[m]的最大值为多少？
例如当绳子长度为8时，分割成2，3，3可以得到最大的乘积18
注意，按照作者的意思，m不是固定的。题目就变成了，n米的绳子剪成多少段可以满足每段的乘积的可以取最大值。

思路：
如果一个问题是在求某个问题的最优解（通常是最大值或者是最小值）
而且该问题可以分解成若干个子问题，并且子问题之间还有重叠的更小的子问题
那么动态规划就可以解决这一类问题。
在应用动态规划之前需要
考虑的是大问题能不能分解成若干个小的子问题，而且子问题要有最优解。

那么这个题目就是要求 乘积的最大值，也就是求一个问题的最优解。
假设第一刀剪在了位置i（i为整数），那么绳子就分成两部分。
对两部分依旧要执行剪绳子，使得剪出来的绳子的乘积达到最大。
所以大问题的最优解依赖于小问题的最优解。
从上往下分析问题，从下往上解决问题。

在应用动态规划的时候，每一步可能有多个选择，比如在剪第一刀的时候有n-1种选择。
由于不知道哪一种选择是最好的，所以只能从头试到尾。
 */
public class JZ14 {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(maxProductAfterCutting(n));//按照作者的意思，只接收绳子长度
    }

    /**
     * 长度为n绳子剪成多少段可以满足每段的乘积的可以取最大值
     *
     * @param n 绳子长度
     * @return 最大的乘积
     */
    public static int maxProductAfterCutting(int n) {
        if (n <= 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;

        int[] products = new int[n + 1];
        //看了一些issues，好多人说n=3的时候输出多少，n=3输出2
        //下面的只是为了递推，当n>3的时候，遇到长度为1，2，3的时候就不需要剪了。
        //递推公式f(n) = max(f(n-i)*f(i))
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <= n; ++i) {
            for (int j = 1; j <= i / 2; ++j) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
            }
            products[i] = max;
        }
        max = products[n];
        return max;
    }
}
