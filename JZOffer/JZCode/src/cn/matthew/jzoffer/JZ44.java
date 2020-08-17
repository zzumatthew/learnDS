package cn.matthew.jzoffer;

/**
 * @ClassName JZ44
 * @Description 数字序列中的某一位数字
 * @Author iematthew
 * @Date 2020/8/17 13:31
 * @Version 1.0
 **/

/*
题目：
数字以0123456789101112131415...的格式序列化到一个字符序列中；
在这个序列中，第5位是5(从下标0开始计数），第13位是1，第19位是4，等等等。
请写一个函数，求任意第n位对应的数字。

思路：
这又是一道找规律的题。这个规律从哪儿看呢？
0-9一共有10个数，一共10位
10-99 一共有90个数(9*10^1)，一共90*2=180位
100-999 一共有900个数(9*10^2)，一共900*3=2700位
1000-9999，一共9000个数(9*10^3)，一共9000*4=36000位

例如找第954位，首先肯定是在3位数，954 > 10+180 但是 954 < 10+180+2700
954-10-180 = 764,从100开始数764位，每3个数一位，764/3=254...2，
也就是从100开始的第254个数的第三位，即354的第三位 4

 */
public class JZ44 {
    public static void main(String[] args) {
        //测试用例 1000000000没有通过 返回-6
    }

    //基本方法
    public static int findNthDigitNum(int n) {
        if (n < 0) return -1;
        int digits = 1;//数位
        while (true) {
            int numbers = countOfInteger(digits);//digits位的数一共有多少个
            if (n < digits * numbers)
                return digitAtNth(n, digits);
            n -= digits * numbers;
            digits++;
        }
    }

    //统计digits位有多少个数（注意已经找好的规律，特殊的只有1位，有10个）
    public static int countOfInteger(int digits) {
        if (digits == 1)
            return 10;
        int count = (int) Math.pow(10, digits - 1);
        return 9 * count;
    }

    //找到第n位的数字
    public static int digitAtNth(int n, int digits) {
        int number = beginNum(digits) + n / digits;//找到了这个数，就在某一位上
        int indexFromRight = digits - n % digits;//具体就在从右往左数第indexFromRight位(上面的余2，就是右数第一位）
        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        return number % 10;
    }

    //digits位最开始的数
    public static int beginNum(int digits) {
        if (digits == 1)
            return 0;
        return (int) Math.pow(10, digits - 1);
    }
}
