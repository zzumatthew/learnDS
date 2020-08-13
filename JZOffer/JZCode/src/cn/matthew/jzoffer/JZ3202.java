package cn.matthew.jzoffer;

import java.util.LinkedList;

/**
 * @ClassName JZ3202
 * @Description TODO
 * @Author iematthew
 * @Date 2020/8/13 10:50
 * @Version 1.0
 **/

/*
题目：
分行从上到下打印二叉树。
从上到下按层打印二叉树，同一层节点按左到右的顺序打印，
每一层打印一行。
例如下面的二叉树
    8
   / \
  6   10
 / \  / \
5  7 9  11

打印
8
6 10
5 7 9 11

思路：
和之前的那道题目一样，也需要用一个栈来保存要打印的节点
为了把二叉树的每一层分行打印，我们需要两个变量。
第一个变量又来表示当前层中还没有打印的节点；
第二个变量用来表示下一层节点的数量。
 */
public class JZ3202 {
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
        printTreeWithLevel(t1);

    }

    public static void printTreeWithLevel(TreeNode root) {
        if (root == null) return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        int nextLevel = 0;//下一层节点的数量
        int toBePrinted = 1;//当前层中还没有被打印的节点
        while (!queue.isEmpty()) {
            TreeNode pNode = queue.pollFirst();
            System.out.printf("%d ", pNode.val);
            --toBePrinted;

            if (pNode.left != null) {
                queue.offerLast(pNode.left);
                ++nextLevel;
            }
            if (pNode.right != null) {
                queue.offerLast(pNode.right);
                ++nextLevel;
            }

            if (toBePrinted == 0) {
                System.out.print("\n");
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
    }
}
