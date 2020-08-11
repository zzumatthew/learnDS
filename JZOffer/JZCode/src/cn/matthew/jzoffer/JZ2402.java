package cn.matthew.jzoffer;

/**
 * @ClassName JZ2402
 * @Description 链表反转 递归实现
 * @Author iematthew
 * @Date 2020/8/11 16:03
 * @Version 1.0
 **/

/*
题目：
用递归实现链表的反转。
 */
public class JZ2402 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode.printNode(reverseListNodeRecur(n1));
    }

    //链表反转的递归实现
    public static ListNode reverseListNodeRecur(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode newHead = reverseListNodeRecur(pHead.next);
        //链表反转
        pHead.next.next = pHead; //一个节点的下一个节点的下一个节点重新指向这个节点，就是链表反转 1->2到2->1的过程
        pHead.next = null;
        return newHead;
    }
}
