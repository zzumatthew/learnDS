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
        //原链表 1->2->3->4
        //反转 4->3->2->1
        ListNode.printNode(reverseListNodeRecur(n1));
    }

    //链表反转的递归实现
    //递归的终止条件是当前节点或者下一个节点为null（其实就是为了找尾节点）
    //完成链表反转需要两个动作
    //1.后一个节点指向前一个节点
    //2.前一个节点的下一个节点为null
    //不要跳到递归里面看问题！整个递归方法本质就做了一个事情：把两个节点反转。
    public static ListNode reverseListNodeRecur(ListNode pNode) {
        if (pNode == null || pNode.next == null) return pNode;
        ListNode newHead = reverseListNodeRecur(pNode.next);//这个是原链表的尾节点
        //链表反转
        pNode.next.next = pNode; //一个节点的下一个节点的下一个节点重新指向这个节点，就是链表反转 1->2到2->1的过程
        pNode.next = null;//切断原本pNode和下一个节点的联系

        //一开始看递归，不知道return的到底是什么
        //尝试用阶乘理解f(6) = 6 * f(5)
        //f(5) = 5 * f(4)...
        //所以f(6)的return看f(5)，f(5)的return看f(4)，以此类推
        //所以这个newHead看第一个被递归函数处理的节点返回了什么
        //第一个被递归函数处理的pNode为原链表的尾节点
        //所以最后的返回值就是原链表的尾节点
        return newHead;
    }
}
