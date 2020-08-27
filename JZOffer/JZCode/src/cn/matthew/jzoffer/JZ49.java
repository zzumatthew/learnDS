package cn.matthew.jzoffer;

/**
 * @ClassName JZ49
 * @Description 丑数
 * @Author iematthew
 * @Date 2020/8/27 10:13
 * @Version 1.0
 **/

/*
题目：
我们把只包含因子2、3、5的数称作丑数。求按从小到大的顺序的第1500个丑数。
例如，6、8都是丑数，但是14不是，因为14包含因子7。
习惯上第一个丑数是1。


 */
public class JZ49 {
    public static void main(String[] args) {
        //下面的测试代码已经通过leetcode测试
    }

    //下面的方法就是凑硬币的另一个翻版
    public static int nthUglyNum(int n) {
        if (n < 0) return -1;
        int[] ugly = new int[n];
        ugly[0] = 1;//初始化
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < n; i++) {
            int n2 = ugly[p2] * 2;
            int n3 = ugly[p3] * 3;
            int n5 = ugly[p5] * 5;
            ugly[i] = Math.min(n2, Math.min(n3, n5));

            if (ugly[i] == n2) p2++;
            if (ugly[i] == n3) p3++;
            if (ugly[i] == n5) p5++;
        }
        return ugly[n - 1];
    }
}
