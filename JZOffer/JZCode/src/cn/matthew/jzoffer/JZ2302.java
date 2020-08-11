package cn.matthew.jzoffer;

/**
 * @ClassName JZ2302
 * @Description JZ23的另外一种思路 - 断链法
 * @Author iematthew
 * @Date 2020/8/11 11:12
 * @Version 1.0
 **/

/*
题目：
如果一个链表包含环，如何找出环的入口节点？

思路：
给到两个指针，p1初始指向头节点的下一个节点，p2指向头节点.
p1一直往前走，p2负责将它的下一个节点变成null；p2等于上一个p1；
当p1又回到入口的时候，下一个节点已经变成了null；此时p2（也是p1）所在的位置就是入口。

不过这种操作会把链表的结构完全破坏。

 */
public class JZ2302 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n3;
        System.out.println(entryNodeOfLoop(n1).val);
    }

    //断链法寻找链表中环的入口
    public static ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;

        ListNode pFast = pHead.next;
        ListNode pSlow = pHead;

        while (pFast != null) {
            pSlow.next = null;
            pSlow = pFast;
            pFast = pFast.next;
        }
        return pSlow;
    }
}
