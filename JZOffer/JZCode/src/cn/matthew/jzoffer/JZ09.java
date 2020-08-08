package cn.matthew.jzoffer;

import java.util.Stack;

/**
 * @description: 用两个栈实现队列
 * @date: 8/7/2020
 * @author: 大帅
 * @version:
 */

/*
题目：
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead，
分别完成在队尾插入节点和在队列头部删除节点的功能

思路：
栈的特点就是FILO，队列的特点就是FIFO；
Queue的Head是stack1的bottom，所以插入节点的时候就直接往stack1中push数据就行；
stack2不为空的时候，删除数据就直接从stack2中pop。
注意：当stack2中为空的时候，stack1中的所有数据都需要push到stack2中，否则顺序就会变乱。
 */
public class JZ09 {
    public static void main(String[] args) {
        //输入1 2 3，输出1 2 3，实现了队列的FIFO特点
        Queue queue = new Queue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}

class Queue{
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    /**
     * 向队列中添加数据 == 向stack1中push数据
     * @param node push的数据
     */
    public void push(int node){
        stack1.push(node);
    }

    /**
     * 从队列中删除数据 == 从stack2中pop数据
     * @return 需要删除的数据
     */
    public int pop(){
        //stack2为空，stack1中的pop的数据都要push到stack2中
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        //stack2不为空，stack2中的数据直接pop
        return stack2.pop();
    }
}
