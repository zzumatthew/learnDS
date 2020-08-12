package cn.matthew.jzoffer;

import java.util.Stack;

/**
 * @ClassName JZ30
 * @Description 包含min函数的栈
 * @Author iematthew
 * @Date 2020/8/12 15:29
 * @Version 1.0
 **/

/*
题目：
定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。
在该栈中，调用min、push、pop的时间复杂度都是O(1)

思路：
只用到一个栈的话肯定是实现不了O(1)，O(1)说明最小的数肯定在栈顶。
用一个栈的时候，不能保证最小的数就在栈顶。
所以需要用到辅助栈。

---------------------------
动画解释
https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/solution/mian-shi-ti-30-bao-han-minhan-shu-de-zhan-fu-zhu-z/
 */
public class JZ30 {
    public static void main(String[] args) {
        MinStack s1 = new MinStack();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(-1);
        s1.push(4);
        s1.pop();
        s1.pop();
        System.out.println(s1.min());
    }
}

class MinStack {
    Stack<Integer> A, B;

    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    //栈中的peek()只返回栈顶值而不像pop()返回并删除
    public void push(Integer x) {
        A.add(x);
        if (B.isEmpty() || B.peek() > x)
            B.add(x);
    }

    //当A中pop出去的数据和B中peek的数据相等，那么执行B.pop()保证两个栈中数据保持一致
    //比如当A中的最小值pop出去了，B中的最小值也要pop出去！
    public void pop() {
        if (A.pop().equals(B.peek()))
            B.pop();
    }

    //B一直都是存着A中加入元素的最小值和次小值
    public int min() {
        return B.peek();
    }
}
