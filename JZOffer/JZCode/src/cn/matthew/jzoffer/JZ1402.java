package cn.matthew.jzoffer;

/**
 * @description: 剪绳子 - 贪婪算法
 * @date: 8/9/2020
 * @author: 大帅
 * @version:
 */

/*
题目：
题目：
给你一根长度为n的绳子，请把绳子剪成m段（m，n都是整数，n>1且m>1），
每段绳子的长度记为k[0],k[1],k[2],...请问k[0]*k[1]*...k[m]的最大值为多少？
例如当绳子长度为8时，分割成2，3，3可以得到最大的乘积18

贪婪算法和动态规划不一样。贪婪算法在每一步都选利益最大化的选项。
贪婪算法一般情况下得到的都不是最优解，得到的也只是次优解。
最优解的时候需要证明当前的贪婪算法的确是最优解。

如果按照以下的策略来剪绳子，那么可以得到各段绳子的长度乘积最大
当n>=5时，需要尽可能多的长度为3的；当n=4的时候，需要剪成两个长度为2的.
但是以上的贪心算法需要证明。

proof：
当n < 4的时候都好证明；
当n = 4的时候，分成2+2比1+3的乘积大
当n > 4的时候，2(n-2) > n且3(n-3) > n,所以应该尽可能剪成长度为2和3的
            且3(n-3) > 2(n-2)，所以应该优先剪成长度为3的。
所以上述的贪心算法可以保证问题的最优解。
 */
public class JZ1402 {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(maxProductAfterCutting(n));
    }

    private static int maxProductAfterCutting(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;

        //尽可能多的剪成3
        int timesOf3 = n / 3;
        //但是当最后的长度剩余4的时候，是不能剪成3+1的，而应该2+2
        if (n - 3 * timesOf3 == 1) {
            timesOf3--;
        }
        int timesOf2 = (n - 3 * timesOf3) / 2;

        return (int) ((int) Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }
}
