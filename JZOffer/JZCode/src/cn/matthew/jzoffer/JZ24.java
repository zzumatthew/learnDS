package cn.matthew.jzoffer;

import java.util.List;

/**
 * @ClassName JZ24
 * @Description 反转链表
 * @Author iematthew
 * @Date 2020/8/11 11:27
 * @Version 1.0
 **/

/*
题目：
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后的链表的头节点。

思路：
很明显一个指针无法解决，所以是有三个指针。
pNode为当前正在处理的节点；
pPer为pNode的前一个节点；
pNext为pNode的后一个节点；
pNode.next = pPre;
pNode = pNext;

 */
public class JZ24 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode.printNode(reverseListNode(n1));
    }

    public static ListNode reverseListNode(ListNode pHead) {
        if (pHead == null) return null;
        ListNode pReverseHead = null;//链表反转之后的头节点
        ListNode pNode = pHead;//当前遍历的节点从头开始
        ListNode pPre = null;//当前节点的前一个节点
        while (pNode != null) {
            ListNode pNext = pNode.next;//当前节点的后一个节点
            if (pNext == null) {
                pReverseHead = pNode;//链表的尾节点就是反转之后的头节点
            }

            pNode.next = pPre;//反转，前一个节点变成下一个节点
            pPre = pNode;
            pNode = pNext;
        }
        return pReverseHead;
    }
}
