package cn.matthew.jzoffer;

/**
 * @description: 替换空格为%20
 * @date: 8/6/2020
 * @author: 大帅
 * @version:
 */

/*
题目：
请实现一个函数，把字符串中的空格替换成%20

输入: We are happy.
输出: We%20are%20happy.

思路：
不要暴力循环！
修改字符串，可以从后面往前面开始。每一个空格被替换成%20，那么字符串的长度都要+2,把StringBuilder申请成新的长度
定义两个指针（实际上Java没有指针的概念），P1指向原字符串的末尾，P2指向新字符串的末尾
P1往前移动，判断P1位置上是什么？
是非空格，那么P2所在的位置就是当前P1所在的字符，P2往前走一位；
是空格，因为是倒着赋值，所以每一位依次复制'0','2','%'，P2往前走三位；
终止条件就是P1=P2

 */
public class JZ05 {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("We are happy.");
        String res = spaceTo20(str);
        System.out.println(res);
    }

    /**
     * 将字符串中的空格替换成20%
     * @param str 输入的字符串
     * @return 替换之后的字符串
     */
    private static String spaceTo20(StringBuilder str) {
        //传入的字符串不合法
        if (str == null){
            System.out.println("输入有误！");
            return null;
        }

        int length = str.length();
        int indexOfOrigin = length - 1;//相当于思路中的P1指针
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                length += 2;//每替换一个空格就要新增2个大小
            }
        }
        str.setLength(length);//str申请新的长度
        int indexOfNew = length - 1;//相当于思路中的P2指针

        //终止条件P1 = P2
        while (indexOfNew > indexOfOrigin){
            if (str.charAt(indexOfOrigin) != ' '){
                //P1指针所在的位置不是空格
                str.setCharAt(indexOfNew--, str.charAt(indexOfOrigin));
            }else {
                //P1指针所在的位置是空格
                str.setCharAt(indexOfNew--,'0');
                str.setCharAt(indexOfNew--,'2');
                str.setCharAt(indexOfNew--,'%');
            }
            indexOfOrigin--;//指针P1往前挪一位
        }
        return str.toString();
    }
}
