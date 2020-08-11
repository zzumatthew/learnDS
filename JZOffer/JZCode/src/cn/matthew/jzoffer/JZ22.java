package cn.matthew.jzoffer;

/**
 * @ClassName JZ22
 * @Description 链表中倒数第K个节点
 * @Author iematthew
 * @Date 2020/8/10 18:09
 * @Version 1.0
 **/

/*
题目：
输入一个链表，输出该链表中的倒数第k个节点。
为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
例如，一个链表有6个节点。从头节点开始，它的值依次是1、2、3、4、5、6，
那么这个链表的倒数第3个节点是4。

思路：
题目中给定的链表是单向的，所以不用考虑先走到链表的尾端再往前走k步。
（可以考虑一下链表反转，再找出第k个，JZ06就是链表反转）
为了只实现遍历链表一次就可以得到倒数第k个节点；
我们可以定义两个指针p1和p2，p1先往前走k-1步；
当p1走到了k步的时候，p2开始向前，因为p1和p2之间的距离为（k-1）；
所以当p1走到了末尾的时候，p2指向的就是链表的倒数第k个。
同时还需要考虑以下各种极端情况：
1.如果输入的链表头为null
2.如果输入的k=0
3.如果链表中的节点数量小于k
 */
public class JZ22 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        //正常测试
        System.out.println(findKthToTail(n1, 2).val);
        //节点数少于k
        System.out.println(findKthToTail(n1, 10).val);
        //k == 0
        System.out.println(findKthToTail(n1, 0).val);

    }

    public static ListNode findKthToTail(ListNode pHead, int k) {
        if (pHead == null || k <= 0) return null;
        ListNode pAhead = pHead;
        for (int i = 1; i < k; i++) {
            pAhead = pAhead.next;
            if (pAhead == null)
                return null;//链表中的节点数少于k，不然第k-1个节点的下一个不会为null
        }
        ListNode pBehind = pHead;
        while (pAhead.next != null) {
            pAhead = pAhead.next;
            pBehind = pBehind.next;
        }
        return pBehind;
    }
}
