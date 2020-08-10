package cn.matthew.jzoffer;

import java.util.List;

/**
 * @ClassName JZ1802
 * @Description 删除链表中重复的节点
 * @Author iematthew
 * @Date 2020/8/10 10:40
 * @Version 1.0
 **/

/*
题目：
在一个排序的链表中，如何删除重复的节点？
例如输入的链表为1-2-3-3-4-4-5，删除重复的就成为了1-2-5

思路：
如果当前节点pNode的val与下一个节点的val相等，那么他们就是重复节点。
为了保证被删除之后的链表是相连的，我们需要把pNode的前一个节点pPreNode
和后面值比pNode.val大的节点相连。
我们要确保pPreNode始终与下一个不重复的节点相连。

所以用到了3个指针，pNode表示当前被检测的节点，pPreNode是前一个节点，pNext是后一个节点。

 */
public class JZ1802 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println("原链表为：");
        ListNode.printNode(n1);
        System.out.println("删除重复节点之后的链表为：");
        ListNode.printNode(deleteDupNodes(n1));

    }

    public static ListNode deleteDupNodes(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode pPreNode = null;//当前节点的前一个节点
        ListNode pNode = pHead;//当前被检测的节点

        while (pNode != null) {
            ListNode pNext = pNode.next;//当前节点的下一个节点
            boolean needDelete = false;//表明节点是否需要被删除
            if (pNext != null && pNext.val == pNode.val)
                needDelete = true;//重复节点

            if (!needDelete) {
                pPreNode = pNode;//不是重复节点，指针往下走，即pPreNode = pNode，pNode = pNode.next
                pNode = pNode.next;
            } else { //出现重复节点
                ListNode pDeleting = pNode; //当前节点需要被删除
                while (pDeleting != null && pDeleting.val == pNode.val) {
                    pNext = pDeleting.next;
                    pDeleting = pNext; //检测所有与pNode重复的节点，最后pNext指向的就是第一个不与pNode重复的节点
                }
                if (pPreNode == null) {
                    pHead = pNext; //说明头部节点被删，需要重新指明头节点
                } else {
                    pPreNode.next = pNext;//保证链表相连，pPreNode与下一个节点连起来
                }
                pNode = pNext;//重复的节点被删除，当前节点pNode = pNext
            }
        }
        return pHead;
    }
}
