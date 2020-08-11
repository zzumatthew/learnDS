package cn.matthew.jzoffer;

import java.util.List;

/**
 * @ClassName JZ25
 * @Description 合并两个排序的链表
 * @Author iematthew
 * @Date 2020/8/11 18:22
 * @Version 1.0
 **/

/*
题目：
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序。
链表1：1->3->5->7
链表2：2->4->6->8
链表3：1->2->3->4->5->6->7->8

思路
首先需要分析链表的合并过程,因为链表已经排好序，所以可以用两个指针
p1指向第一个链表的头节点，p2指向第二个链表的头节点。
 */
public class JZ25 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode k1 = new ListNode(2);
        ListNode k2 = new ListNode(4);
        ListNode k3 = new ListNode(6);
        ListNode k4 = new ListNode(8);
        k1.next = k2;
        k2.next = k3;
        k3.next = k4;

        ListNode mergeHead = mergeListNode(n1, k1);
        ListNode.printNode(mergeHead);

    }

    public static ListNode mergeListNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null) {
            return pHead2;
        } else if (pHead2 == null) {
            return pHead1;
        }

        ListNode pMergeHead = null;
        if (pHead1.val < pHead2.val) {
            pMergeHead = pHead1;
            pMergeHead.next = mergeListNode(pHead1.next, pHead2);
        } else {
            pMergeHead = pHead2;
            pMergeHead.next = mergeListNode(pHead1, pHead2.next);
        }

        return pMergeHead;//返回合并之后的头节点
    }
}
