package cn.matthew.hot100;

/**
 * @ClassName Leetcode02
 * @Description 两数相加
 * @Author iematthew
 * @Date 2020/9/12 21:51
 * @Version 1.0
 **/

/*
给出两个非空 的链表用来表示两个非负的整数。
其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0开头。

 */
public class Leetcode02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;//当前两个数字的累加结果
        int carry = 0;//存储进位信息
        int newNum = 0;//当前应该填入的数字

        ListNode root = new ListNode(0);//定义头结点
        ListNode cur = root;//当前处理的节点

        while (l1 != null || l2 != null) {
            //下面5行代码是解题的关键，数字的处理问题
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            sum = l1Val + l2Val + carry;
            carry = sum / 10;
            newNum = sum % 10;

            ListNode newListNode = new ListNode(newNum);
            cur.next = newListNode;//给定指向
            cur = newListNode;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            //调试的时候发现[5] [5]返回[0,1]，下面的代码没有写就会返回[0]
            if (l1 == null && l2 == null && carry == 1) {
                newListNode = new ListNode(1);
                cur.next = newListNode;
            }

        }
        return root.next;
    }
}
