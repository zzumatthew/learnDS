package cn.matthew.jzoffer;

import java.util.Stack;

/**
 * @ClassName JZ31
 * @Description 栈的压入、弹出序列
 * @Author iematthew
 * @Date 2020/8/12 16:35
 * @Version 1.0
 **/

/*
题目：
输入两个整数序列，第一个序列表示栈的压入顺序，
请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
例如，序列{1,2,3,4,5}是某栈的压栈序列，
序列{4,5,3,2,1}可以是{1,2,3,4,5}压栈顺序的弹出顺序
push(1,2,3,4) pop(4) push(5) pop(5,3,2,1)
所以压入顺序是{1,2,3,4,5}的时候，是有办法实现弹出顺序是{4,5,3,2,1}的

注意理解题目的意思！题目是让判断popped序列有没有可能是pushed的一种弹出。
pushed并不是一直push的，不然不可能问这么简单的问题！
思路：

 */
public class JZ31 {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5, 6};
        int[] popped = {5, 6, 4, 3, 2, 1};
        System.out.println(isPopOrder(pushed, popped));
    }

    public static boolean isPopOrder(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) return false;

        Stack<Integer> stack = new Stack();//辅助栈
        int i = 0;
        for (int k : pushed) {
            stack.push(k);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
