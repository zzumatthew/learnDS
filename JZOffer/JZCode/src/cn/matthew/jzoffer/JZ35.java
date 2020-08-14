package cn.matthew.jzoffer;

import java.util.List;

/**
 * @ClassName JZ35
 * @Description 复杂链表的复制
 * @Author iematthew
 * @Date 2020/8/14 10:31
 * @Version 1.0
 **/

/*
题目：
请实现一个copyRandomList函数，复制一个复杂链表。
在复杂链表种，每个节点除了有一个next指针指向下一个节点，
还有一个random指针指向链表中的任意节点或者null。

思路：
剑指offer中提供的思路，还比较容易理解。
复制复杂的链表，可以分为如下几步。
第一步：每个节点各自复制一份，并连接到自己的后面；
第二步：复制的节点的指向和原始的指向一致；
第三步：把奇数位置的节点连接起来就是原始链表，把偶数位置的节点连接起来就是复制的链表。
 */
public class JZ35 {
    public static void main(String[] args) {
        //方法已通过Leetcode测试
    }

    public static ListNode copyRandomList(ListNode pHead) {
        //第一步，节点的自身复制并链接
        cloneSelf(pHead);
        //第二步，复制节点的指向
        connectSIblingNode(pHead);
        //第三步，链表的剥离
        return reconnectNode(pHead);
    }

    //第一步：完成节点自身的复制，复制节点的前一个就是自己，后一个是原本指向的后一个
    private static void cloneSelf(ListNode pHead) {
        //pNode为当前在处理的节点
        ListNode pNode = pHead;
        while (pNode != null) {
            ListNode pClone = new ListNode(pNode.val);
            pClone.next = pNode.next;
            pClone.random = null;
            pNode.next = pClone;
            pNode = pClone.next;
        }
    }

    //第二步：调整复制节点的指向
    private static void connectSIblingNode(ListNode pHead) {
        ListNode pNode = pHead;
        while (pNode != null) {
            ListNode pClone = pNode.next;
            if (pNode.random != null) {
                pClone.random = pNode.random.next;
            }
            pNode = pClone.next;
        }
    }

    //第三步：链表的剥离
    private static ListNode reconnectNode(ListNode pHead) {
        ListNode pNode = pHead;
        ListNode pCloneHead = null;
        ListNode pCloneNode = null;
        if (pNode != null) {
            pCloneHead = pHead.next;//复制链表的头节点
            pCloneNode = pNode.next;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;

        }

        //此时pNode已经走到下一个pNode了，看图会很容易理解下面的循环过程
        //A - A' - B - B' - ...
        //    ↑    ↑
        //   pC    pN
        while (pNode != null) {
            pCloneNode.next = pNode.next;
            pCloneNode = pCloneNode.next;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;
        }

        return pCloneHead;
    }
}
