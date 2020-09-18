package cn.matthew.hot100;

import java.util.Stack;

/**
 * @ClassName Leetcode32
 * @Description 最长的有效括号
 * @Author iematthew
 * @Date 2020/9/18 09:06
 * @Version 1.0
 **/

/*
遍历所给定的字符串
如果遇到(，那么就把对应的下标push进去
如果遇到)，那么先把栈弹出
    如果栈为空，那么把）的下标push进去
    如果栈不为空，那么把)的下标减去栈顶的元素，得到len
    更新maxLen
 */
public class Leetcode32 {
    public int longestBrackets(String s) {
        if (s == null || s.length() < 2) return 0;
        //当前计算的长度
        int len = 0;
        //最长的长度
        int maxLen = 0;
        int sLen = s.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < sLen; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int num = stack.peek();
                    len = i - num;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;
    }
}
