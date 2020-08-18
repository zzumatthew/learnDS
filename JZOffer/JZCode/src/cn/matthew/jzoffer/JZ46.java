package cn.matthew.jzoffer;

/**
 * @ClassName JZ46
 * @Description 把数字翻译成字符串
 * @Author iematthew
 * @Date 2020/8/17 17:59
 * @Version 1.0
 **/

/*
题目：
给定一个数字，我们按照如下翻译规则把它翻译成字符串：
0 -> a
1 -> b
...
11 -> l
...
25 -> z
问，一个数字有多少种翻译？
例如112可以1 1 2(aab)，11 2(lb)，1 12(bm)

话说这个题目是不是有点像前面的青蛙跳台阶？给一个台阶一共有多少种跳法。
这里就是给一个数字有多少种翻译方法。
依然是不能从前往后算，具体的原因在青蛙跳台阶里面已经有所说明，有很多重复的计算。

 */
public class JZ46 {
    public static void main(String[] args) {
        System.out.println(translateNum(1205));
    }

    //不过最简单的想法还是递归
    public static int translateNum(int n) {
        if (n < 10) return 1;
        if (n < 26) return 2;
        if (n < 100) return 1;
        int n2 = n % 100;
        //对于n2的分析，如果n2 < 10或者 n2 > 26，比如1205，那么5没有办法和0合体，所以下一轮递归中去掉
        //下一轮就从1205 / 10 = 120开始
        //120 % 100 = 20，9 < 20 < 26，所以有12和20进入下一轮递归
        //12和20都是大于10小于26
        //1205：1 2 0 5，12 0 5，1 20 5，
        return translateNum(n / 10) + (n2 < 26 && n2 > 9 ? translateNum(n / 100) : 0);
    }
}
