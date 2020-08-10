package cn.matthew.jzoffer;

import java.util.Stack;

/**
 * @description: 从尾到头打印链表
 * @date: 8/6/2020
 * @author: 大帅
 * @version:
 */

/*
题目：
输入一个链表的头节点，从头到尾反过来打印出每个节点的值

思路：
节点遍历顺序只能从头到尾，但是输出的顺序却为从尾到头，是后进先出的问题。
方法1.栈实现，先压栈再弹栈；
方法2.递归实现。
 */
public class JZ06 {
    public static void main(String[] args) {
        //生成一个链表
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println("栈实现的结果：");
        reverseLinkNode(listNode1);
        System.out.println("递归实现的结果：");
        reverseLinkNode2(listNode1);
    }

    /**
     * 用栈处理
     * @param node 输入的链表第一个节点
     */
    private static void reverseLinkNode(ListNode node) {
        Stack<ListNode> stack = new Stack<>();
        while (node != null){
            stack.push(node);
            node = node.next;
        }
        while (!stack.empty()){
            System.out.println(stack.pop().val);
        }
    }

    /**
     * 用递归处理（深刻理解递归的用法）
     * @param node 输入的链表的第一个节点
     */
    private static void reverseLinkNode2(ListNode node){
        if (node != null){
            reverseLinkNode2(node.next);
            System.out.println(node.val);
        }
    }

}

//链表结构
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }

    public static void printNode(ListNode curr){
        if (curr != null){
            while (curr.next != null){
                System.out.print(curr.val + "->");
                curr = curr.next;
            }
            System.out.println(curr.val);
        }else {
            System.out.println();
        }
    }
}
