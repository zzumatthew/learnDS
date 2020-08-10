package cn.matthew.jzoffer;

/**
 * @description: 二进制中1的个数
 * @date: 8/9/2020
 * @author: 大帅
 * @version:
 */

/*
题目：
请实现一个函数，输入一个整数，输出该数二进制表示中的1的个数。
例如把9转化为二进制数为1001，有两个1，因此输出为2；

思路：
位运算是把数字用二进制表示之后，对每一位上的0或者1的运算。
位运算的左移：m<<n表示把m左移n位，最左边的n位会被丢弃，同时在最右边补上n个0
位运算的右移：m>>n表示把m右移n位，当m是一个正数的时候，最最右边的n位会被丢弃
            同时左边补n个0；如果是负数，那么就补n个1。
 */
public class JZ15 {
    public static void main(String[] args) {
        int num = -15;
        System.out.println(Integer.toBinaryString(num));
        System.out.printf("%d的二进制数中有%d个1\n", num, numOf1(num));
        System.out.printf("%d的二进制数中有%d个1\n", num, numOf1_2(num));

    }

    /**
     * 解法1
     * 用1来&操作每一位，因为只有1&1 = 1，所以不为1的与之后就是0，每测试一位，flag左移1位。
     *
     * @param i 输入的十进制数
     * @return 二进制中1的个数
     */
    private static int numOf1(int i) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((i & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 解法2
     * 把一个整数-1，再和原来的数进行与操作，会把该整数最右边的1变成0.
     * 二进制有多少个1，就可以进行多少次这样的操作。直到整个数变成0
     *
     * @param num
     * @return
     */
    private static Object numOf1_2(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }
}

