package cn.matthew.hot100;

import java.util.Stack;

/**
 * @ClassName Leetcode20
 * @Description 有效的括号
 * @Author iematthew
 * @Date 2020/9/15 22:00
 * @Version 1.0
 **/

/*
有效的括号
符合IDE语法的括号才算是有效的。{[()]} 有效，{[}]不合法
 */
public class Leetcode20 {
    public boolean isValid(String s) {
        if (s == null) return true;
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
