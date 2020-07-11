package chap01;

import java.util.Scanner;

/**
 * @ClassName Ex09
 * @Description 第一章练习题9
 * @Author iematthew
 * @Date 2020/7/11 22:18
 * @Version 1.0
 **/

/*
编写一段代码，将一个正整数N用二进制表示并转换为一个String类型的值s
Java中有一个内置的方法Integer.toBinaryString(int N)
 */
public class Ex09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入需要转化的整数：");
        System.out.println(int2Binary(sc.nextInt()));
    }

    /**
     * 除K取余法求二进制
     * @param N 输入需要转化为二进制的数
     * @return 二进制字符串
     */
    public static String int2Binary(int N){
        String res = "";
        for (int i = N; i > 0 ; i /= 2) {
            res += (i % 2);
        }
        return stringReverse(res);
    }

    /**
     * 字符串反转
     * @param s 需要进行反转的字符串
     * @return 反正过后的字符串
     */
    public static String stringReverse(String s){
        int len = s.length();
        if (len == 1 || len == 0) return s;
        String stringLeft = s.substring(0,len/2);
        String stringRight = s.substring(len/2 , len);
        return stringReverse(stringRight) + stringReverse(stringLeft);
    }

}

