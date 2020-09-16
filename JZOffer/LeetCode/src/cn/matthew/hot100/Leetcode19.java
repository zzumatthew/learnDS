package cn.matthew.hot100;

/**
 * @ClassName Leetcode19
 * @Description 删除链表的倒数第K个节点
 * @Author iematthew
 * @Date 2020/9/15 20:57
 * @Version 1.0
 **/

/*
思路：
剑指22题是返回倒数第K个节点。
现在是删除倒数第K个节点，那么就要返回倒数第K+1个节点；
然后倒数第K+1个节点的next为倒数第k-1个节点。
 */
public class Leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null || head.next == null) return null;

        ListNode pre = new ListNode(0);//链表的头结点
        pre.next = head;
        ListNode ahead = head;
        ListNode behind = head;

        for (int i = 0; i < n; ++i) {
            ahead = ahead.next;
        }

        //测试用例[1,2] n=2的时候，返回空指针
        //因为跑得快的ahead已经跑到了null；
        if (ahead == null) return pre.next.next;

        while (ahead.next != null) {
            ahead = ahead.next;
            behind = behind.next;
        }
        behind.next = behind.next.next;

        return pre.next;
    }
}
