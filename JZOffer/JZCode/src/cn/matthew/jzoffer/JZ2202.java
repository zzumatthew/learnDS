package cn.matthew.jzoffer;

/**
 * @ClassName JZ2202
 * @Description JZ22题扩展：求链表的中间节点
 * @Author iematthew
 * @Date 2020/8/11 08:09
 * @Version 1.0
 **/

/*
题目：
求一个链表的中间节点。

思路：
如果链表节点的数量是奇数，那么就恰好返回正中间的节点；
如果链表节点的数量是偶数，那么就返回中间的两个节点中的任意一个。
为了解决这个问题，一样可以借用两个指针。
其中一个指针每次走一步，另外一个指针每次走两步。
这样走的快的指针走到了末尾的时候，走的慢的指针就指在乐中间的位置。

举一反三：
在单向链表中，一个指针解决不了的事情，可以考虑有几个指针一起。
最关键的也是最难的就是寻找规律，规律想好了事情也就变得很简单了。
 */
public class JZ2202 {
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
        //正常测试
        System.out.println(findMidNode(n1).val);
        //null测试
        System.out.println(findMidNode(null).val);
    }

    private static ListNode findMidNode(ListNode pHead) {
        if (pHead == null) return null;
        ListNode p1 = pHead;//p1每次走两步
        ListNode p2 = pHead;//p2每次走一步
        while (p1.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
        }
        return p2;
    }
}
