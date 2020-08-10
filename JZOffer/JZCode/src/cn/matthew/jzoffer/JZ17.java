package cn.matthew.jzoffer;

/**
 * @description: 打印从1到最大的n位数
 * @date: 8/9/2020
 * @author: 大帅
 * @version:
 */

/*
题目：
输入数字n，一直从1，2，3打印到n位最大数。
例如输入2，则一直要打印到99；
输入3，则一直要打印到999。以此类推。

思路：
这道题的心机在于没有说n的取值范围，所以用基本数据类型可能都存在溢出。
那么问题就是怎么来表达大数？字符串是一种有效的方法。

方法1
首先把字符串的每一位都初始化位'0',然后每一次为字符串的表示的数字+1，然后再打印出来。
所以需要做两件事：第一就是在字符串表达的数字上模拟做加法，第二就是要把字符串表达的数字打印出来

方法2
把每一位从0-1全排列就可以得到1-n位数的最大值


 */
public class JZ17 {
    public static void main(String[] args) {
        int n = 2;
        print1ToN(n);
    }

    private static void print1ToN(int n) {
        if (n <= 0) return;
        //把字符串的每一位都初始化为'0'
        char[] strNum = new char[n];
        for (int i = 0; i < strNum.length; i++) {
            strNum[i] = '0';
        }

        for (int i = 0; i < 10; i++) {
            strNum[0] = (char) (i + '0');
            print1ToNRecursively(strNum, 0);
        }

    }

    private static void print1ToNRecursively(char[] strNum, int index) {
        if (index == strNum.length - 1) {
            printStrNum(strNum);
            return;
        }

        for (int i = 0; i < 10; i++) {
            strNum[index + 1] = (char) (i + '0');
            print1ToNRecursively(strNum, index + 1);
        }
    }

    //打印的时候，由于字符串是'0101'这种，所以遇到第一个不为'0'的才开始打印
    private static void printStrNum(char[] strNum) {
        boolean isBeginning0 = true;
        for (int i = 0; i < strNum.length; i++) {
            if (isBeginning0 && strNum[i] != '0')
                isBeginning0 = false;

            if (!isBeginning0) {
                System.out.printf("%c", strNum[i]);
            }

        }
        System.out.printf("\n");
    }
}
