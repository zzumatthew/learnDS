package cn.matthew.jzoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 用两个队列实现一个栈
 * @date: 8/8/2020
 * @author: 大帅
 * @version:
 */

/*
思路：
queuq1中的数据出队列到queue2中，直到queue1剩余最后一个数据。
这个数据出队列，就可以实现LIFO。
总是要保证有一个队列一直为空，不为空的队列只能不断的把数据加到空队列中且留一个数据出队列。
空队列不能加数据（第一次初始化都是空的，随便加一个）
 */
public class JZ0902 {
    public static void main(String[] args) throws Exception {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());//3
        System.out.println(stack.pop());//2
        stack.push(4);
        System.out.println(stack.pop());//4
        System.out.println(stack.pop());//1 测试结果符合LIFO要求
    }
}

//用两个队列模拟的栈
class Stack{
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    /**
     * 模拟数据压栈
     * @param i 要压入的数据
     * @return 压入成功与否
     */
    public boolean push(Integer i){
        if (!queue1.isEmpty()){
            //offer（）和add（）的区别在于，超出界限之后前者返回false后者异常
            return queue1.offer(i);
        }else {
            return queue2.offer(i);
        }
    }

    /**
     * 模拟数据出栈
     * @return 出栈的数据
     * @throws Exception 队列为空异常
     */
    public Integer pop() throws Exception {
        if (queue1.isEmpty() && queue2.isEmpty())
            throw new Exception("两个队列的数据都为空！");
        if (queue1.isEmpty() && !queue2.isEmpty()){
            //queue1为空
            while (queue2.size() > 1){
                queue1.offer(queue2.poll());//queue2中的数据除了最后一个都要进到queue1中
            }
            return queue2.poll();//queue2的最后一个数据出队列(相当于LIFO）
        }
        if (!queue1.isEmpty() && queue2.isEmpty()){
            while (queue1.size() > 1){
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
        return null;
    }
}
