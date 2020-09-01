package cn.matthew.jzoffer;

/**
 * @ClassName JZ58_01
 * @Description 翻转单词顺序
 * @Author iematthew
 * @Date 2020/9/01 18:19
 * @Version 1.0
 **/

/*
题目：
输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
为简单起见，标点符号和普通字母一样处理。
例如
输入 I am a student.
输出 student. a am I

思路：
1.感觉可以以空格分割

 */
public class JZ58_01 {
    public static void main(String[] args) {
        String s = "I am a student.";
        System.out.println(reverseWords(s));
    }


    public static String reverseWords(String src) {
        if (src == null) return null;

        StringBuilder sb = new StringBuilder();
        String[] srcSplit = src.split(" ");

        for (int i = srcSplit.length - 1; i >= 0; i--) {
            sb.append(srcSplit[i]);
            sb.append(" ");
        }

        return new String(sb).trim();
    }
}
