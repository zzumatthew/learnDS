package cn.matthew.jzoffer;


import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JZ3203
 * @Description 之字形打印二叉树
 * @Author iematthew
 * @Date 2020/8/13 17:03
 * @Version 1.0
 **/

/*
题目：
请实现一个函数，按照之字形顺序打印二叉树。
即第一层按照从左到右的顺序打印。
第二层按照从右到左的顺序打印。
第三层按照从左到右的顺序打印。

输入：
    8
   / \
  6   10
 / \  / \
5  7 9  11

输出
8
10 6
5 7 9 11

思路：
按照前面一道题的思路，很容易想到要用到栈结构
这里可以发现规律就是奇数层从左到右，偶数层从右到左；因此可以用双栈来处理！
当在奇数层的时候，奇数层的节点先把左子节点push进去，再把右子节点push进去；
然后按照栈的顺序pop出来；
当在偶数层的时候，偶数层的节点先把右子节点push进去，再把左子节点push进去；
然后按照栈的顺序pop出来；

结束条件就是两个栈都为空（在整个过程中有一个栈始终在pop，有一个始终在push）。
 */
public class JZ3203 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        TreeNode t7 = new TreeNode(11);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        printTreeInZigzag(t1);
    }

    public static void printTreeInZigzag(TreeNode root) {
        if (root == null) return;
        List<Stack<TreeNode>> stackList = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stackList.add(stack1);
        stackList.add(stack2);

        int current = 0;
        int next = 1;
        stackList.get(current).push(root);

        while (!stackList.get(0).isEmpty() || !stackList.get(1).isEmpty()) {
            TreeNode pNode = stackList.get(current).peek();
            stackList.get(current).pop();
            System.out.printf("%d ", pNode.val);
            //奇数level，先push左再push右，那么pop的时候就是先右再左
            if (current == 0) {
                if (pNode.left != null) {
                    stackList.get(next).push(pNode.left);
                }
                if (pNode.right != null) {
                    stackList.get(next).push(pNode.right);
                }
            } else {
                if (pNode.right != null) {
                    stackList.get(next).push(pNode.right);
                }
                if (pNode.left != null) {
                    stackList.get(next).push(pNode.left);
                }
            }

            //当前的栈左右元素都已经弹出，那么换行，当前的栈与下一个栈交替进行
            if (stackList.get(current).empty()) {
                System.out.println();
                current = 1 - current;
                next = 1 - next;
            }
        }
    }
}
