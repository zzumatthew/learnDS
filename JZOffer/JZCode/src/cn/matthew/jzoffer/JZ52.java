package cn.matthew.jzoffer;

/**
 * @ClassName JZ52
 * @Description 两个链表的第一个公共节点
 * @Author iematthew
 * @Date 2020/8/27 23:13
 * @Version 1.0
 **/

/*
题目：
输入两个链表，找出它们的第一个公共节点。

思路：
1.剑指的思路，先遍历得到两个链表的长度，长的链表先走若干步，然后一起走，直到遇到相同的节点。
不过要注意的是，一开始以为只是找到相同的数值的节点就算了，后面看测试用例发现，是nodeA == nodeB,
而不仅仅是nodeA.val == nodeB.val!

2.leetcode思路，追及问题。链表A和链表B一起走，各自走完之后走对方的链表。
一定会相遇的！（如果不相遇，说明没有公共部分，那么都是同时到达next == null，依旧可以说相遇，只不过在NULL相遇。

不过统一来看，两个思路都是追及问题。
 */
public class JZ52 {
    public static void main(String[] args) {
        //方法已经通过测试用例
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        //追及问题,双指针
        ListNode nA = headA;
        ListNode nB = headB;
        while (nA != nB) {
            nA = nA == null ? headB : nA.next;
            nB = nB == null ? headA : nB.next;
        }
        return nA;
    }
}
