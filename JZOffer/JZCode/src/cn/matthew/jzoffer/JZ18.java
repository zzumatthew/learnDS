package cn.matthew.jzoffer;

/**
 * @ClassName JZ18
 * @Description 删除链表的节点
 * @Author iematthew
 * @Date 2020/8/10 09:43
 * @Version 1.0
 **/

/*
题目：
在O(1)时间内删除链表的节点
给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点。

思路：
常规思路就是从头开始遍历链表，找到需要删除的节点的前一个节点，然后将前一个节点指向后一个节点。
但是这样的话时间复杂度就不是O(1)而是O(n)了。
所以现在思路就是，不一定要得到前一个节点，直接把后面一个节点复制到这个节点，然后删掉后面一个节点。
这样的话，时间复杂度才可能是O(1)

1.删除的节点不是头结点不是尾节点
2.删除的节点是头结点
3.删除的节点是尾节点：需要从头结点开始，顺序遍历得到该节点的前一个节点

bug：这道题必须以需要删除的节点必须在链表中，否则依旧要遍历来检查该节点是否存在。

启发：
在有关链表的操作的时候，往往需要注意节点所处的位置，头节点、中间节点和尾节点，可能处理的方法略微不同。
 */
public class JZ18 {
    public static void main(String[] args) {
        //初始化链表
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        System.out.println("原链表为：");
        ListNode.printNode(n1);
        System.out.println("删除节点之后的链表为：");
        ListNode.printNode(deleteListNode(n1, n1));

    }

    /**
     * 删除链表中的节点
     *
     * @param head     链表的头结点
     * @param deleting 需要删除的节点
     * @return 返回头结点
     */
    private static ListNode deleteListNode(ListNode head, ListNode deleting) {
        if (head == null || deleting == null) return head;
        //deleting不是尾节点
        if (deleting.next != null) {
            ListNode next = deleting.next;
            //下一个节点覆盖需要被删除的节点。删除下一个节点
            deleting.val = next.val;
            deleting.next = next.next;
            next = null;
        } else if (head == deleting) { //链表中只有一个节点
            deleting = null;
            head = null;
        } else { //链表中有多个节点，删除的是尾节点,从头遍历
            ListNode flagNode = head;
            while (flagNode.next != deleting && flagNode != null)
                flagNode = flagNode.next;
            if (flagNode == null) {
                System.out.println("出错");
                return head;
            }
            flagNode.next = null;//尾节点被删除
        }
        return head;
    }

}

//class ListNode{
//    int val;
//    ListNode next;
//
//
//    public ListNode(int val) {
//        this.val = val;
//    }
//
//    public static void printNode(ListNode curr){
//        if (curr != null){
//            while (curr.next != null){
//                System.out.println(curr.val);
//                curr = curr.next;
//            }
//            System.out.println(curr.val);
//        }else {
//            System.out.println();
//        }
//    }
//
//}

