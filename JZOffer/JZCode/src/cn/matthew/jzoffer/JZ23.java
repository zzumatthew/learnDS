package cn.matthew.jzoffer;

/**
 * @ClassName JZ23
 * @Description 链表中环的入口节点
 * @Author iematthew
 * @Date 2020/8/11 08:08
 * @Version 1.0
 **/

/*
题目：
如果一个链表包含环，如何找出环的入口节点？

思路：
首先需要确定的是这个链表的确有环：
同样一个指针解决不了就用两个指针，p1从头开始一次走两步，p2从头开始一次走一步；
如果p1能够追上p2说明链表有环

接着是要找到链表的环的入口：
先定义两个指针p1和p2；
如果链表中的环有n个节点，那么先让p1前进n步，接着p1，p2一起移动，二者相遇的就是入口。

最后的问题就是如何确定环中的节点的数量：
在第一步中，两个快慢指针相遇必定是在环里面。从相遇的时候开始计数（+1），直到又回到这个地方。

先解决第一个问题，顺便找出相遇的节点；
再解决第三个问题，利用相遇节点计算出环的长度；
最后解决第二个问题，根据环的长度确定环的入口。

 */
public class JZ23 {
    public static void main(String[] args) throws Exception {
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
        System.out.println("链表中环的入口节点的值为：" + findLoopStart(n1).val);
    }

    /**
     * 寻找链表中的环的入口
     * 如果链表中的环有n个节点，那么先让p1前进n步
     * 接着p1，p2一起移动，二者相遇的就是入口
     *
     * @param head 链表的头节点
     * @return 环中入口节点
     */
    public static ListNode findLoopStart(ListNode head) throws Exception {
        if (head == null || head.next == null) return null;

        ListNode p1 = head;
        ListNode p2 = head;

        int count = getCircleLen(head);
        if (count <= 0) return null;

        //先让p1走count步
        for (int i = 0; i < count; i++) {
            p1 = p1.next;
        }

        //接着p1和p2一起走，二者相遇就是入口
        while (p1 != null && p2 != null) {
            if (p1 == p2) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }

        return null;
    }

    /**
     * 获取环的长度
     * 从相遇的时候开始计数（+1），直到又回到这个地方。
     *
     * @param head 链表的头节点
     * @return 环的长度
     */
    public static int getCircleLen(ListNode head) {
        ListNode meetingNode = getMeetingNode(head);
        if (meetingNode != null) {
            ListNode pFlag = meetingNode.next;//pFlag会一直往前走，直到再次和meetingNode相遇
            int count = 1;
            while (pFlag != null) {
                if (pFlag == meetingNode)
                    return count;

                count++;
                pFlag = pFlag.next;
            }
        }
        return 0;
    }

    /**
     * 获取相遇的节点
     * p1从头开始一次走两步，p2从头开始一次走一步；
     * 如果p1能够追上p2说明链表有环，相遇时候的节点可得到。
     *
     * @param head 链表的头节点
     * @return 返回相遇的节点
     */
    public static ListNode getMeetingNode(ListNode head) {
        ListNode pFast = head;
        ListNode pSlow = head;
        while (pSlow != null && pFast != null && pFast.next != null) {
            pFast = pFast.next.next;
            pSlow = pSlow.next;
            if (pFast == pSlow) {
                return pFast;//相遇节点
            }
        }
        return null;
    }
}
