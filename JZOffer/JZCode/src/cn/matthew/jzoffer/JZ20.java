package cn.matthew.jzoffer;

/**
 * @ClassName JZ20
 * @Description 表示数值的字符串
 * @Author iematthew
 * @Date 2020/8/10 11:58
 * @Version 1.0
 **/

/*
题目：
请实现一个函数用来判断一个字符串是否是表示数字（包括整数和小数）
例如，字符串"+100","5e2","-123","3.1416"及"-1E-16"都是数字；
但是"12e","1a3.14","1.2.3","+-5","12e+5.4"都不是数字。

思路：
还是需要用正则表表达式来处理这种类型的题目。
表示数值的字符串遵循的正则表达式为A.[.[B]][e|EC],其中A为数值的整数部分，
B紧跟着小数点为数值的小数部分，C紧跟着e或者E为数值的指数部分。
在小数里面。A不是必须的。A、C都可以是以+-开头的0-9，B是不能为+-的0-9

 */
public class JZ20 {
    public static void main(String[] args) {
        String str = "-1E-16";
        System.out.println(isNumeric(str.toCharArray()));
    }

    private static boolean isNumeric(char[] str) {
        if (str == null) return false;

        int[] index = {0};
        //遍历字符串的整数部分A
        boolean numeric = scanInteger(str, index);
        //遇到小数点就遍历B
        if (index[0] < str.length && str[index[0]] == '.') {
            index[0]++;
            //用||的原因
            //1.小数可以没有整数部分
            //2.小数点后面可以没有数字 233.也是可以的
            //3.小数点的前面和后面都可以有数字
            numeric = scanUnsignedInteger(str, index) || numeric;
        }
        //遇到e或者E遍历C
        if (index[0] < str.length && (str[index[0]] == 'e' || str[index[0]] == 'E')) {
            index[0]++;
            //用&&的原因
            //1.当e前面没有数字的时候，不能表示一个数字，比如e3
            //2.当e后面没有数字或者不是一个整数的时候也不能表示一个数字，比如12e，12e2.4
            numeric = scanInteger(str, index) && numeric;
        }

        return numeric && (index[0] == str.length);
    }

    //用于扫描B部分，B部分不允许出现+-
    private static boolean scanUnsignedInteger(char[] str, int[] index) {
        int before = index[0];
        while (index[0] < str.length && str[index[0]] <= '9' && str[index[0]] >= '0') {
            index[0]++;
        }
        return index[0] > before;
    }

    //用于扫描A、C部分，AC部分可以出现+-
    private static boolean scanInteger(char[] str, int[] index) {
        if (index[0] < str.length && (str[index[0]] == '+' || str[index[0]] == '-')) {
            index[0]++;
        }
        return scanUnsignedInteger(str, index);
    }
}
