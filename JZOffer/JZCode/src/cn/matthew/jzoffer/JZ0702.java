package cn.matthew.jzoffer;

import java.util.Stack;

/**
 * @description: 二叉树的 6 种遍历
 * @date: 8/7/2020
 * @author: 大帅
 * @version:
 */

/*
二叉树有前序遍历、中序遍历和后序遍历。每一种遍历里面又可以分为递归实现和循环实现。
前序遍历：先访问根节点，再访问左子节点，最后访问右子节点，10-6-4-8-14-12-16
中序遍历：先访问左子节点，再访问根节点，最后访问右子节点，4-6-8-10-12-14-16
后序遍历：先访问左子节点，再访问右子节点，最后访问根节点，4-8-6-12-16-14-10
以下为一种示例的树结构
      10
   /     \
  6      14
 / \    /  \
4   8  12  16

 */
public class JZ0702 {
    public static void main(String[] args) {
        TreeNode root = JZ0702.init();
        System.out.println("前序遍历");
        preOrder(root);
        System.out.println("中序遍历");
        inOrder(root);
        System.out.println("后序遍历");
        postOrder(root);
        System.out.println("非递归前序遍历");
        normalPreOrder(root);
        System.out.println("非递归中序遍历");
        normalInOrder(root);
        System.out.println("非递归后序遍历");
        normalPostOrder(root);
    }

    /**
     * 打印传入的节点
     * @param treeNode 输入的结点
     */
    private static void printNode(TreeNode treeNode){
        System.out.println(treeNode.getVal());
    }

    /**
     * 递归实现前序遍历：根 - 左 - 右
     *
     * @param root 根节点
     */
    public static void preOrder(TreeNode root) {
        printNode(root);
        if (root.getLeft() != null) preOrder(root.getLeft());
        if (root.getRight() != null) preOrder(root.getRight());
    }

    /**
     * 递归实现中序遍历：左 - 根 - 右
     *
     * @param root 根节点
     */
    public static void inOrder(TreeNode root) {
        if (root.getLeft() != null) inOrder(root.getLeft());
        printNode(root);
        if (root.getRight() != null) inOrder(root.getRight());
    }

    /**
     * 递归实现后序遍历：左 - 右 - 根
     *
     * @param root 根节点
     */
    public static void postOrder(TreeNode root) {
        if (root.getLeft() != null) postOrder(root.getLeft());
        if (root.getRight() != null) postOrder(root.getRight());
        printNode(root);
    }

    /**
     * 非递归实现前序遍历：根 - 左 - 右
     *
     * @param root
     */
    public static void normalPreOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                printNode(node);
                stack.push(node);
                node = node.getLeft();
            } else {
                node = stack.pop();
                node = node.getRight();
            }
        }
    }

    /**
     * 非递归实现中序排列：左 - 根 - 右
     *
     * @param root
     */
    public static void normalInOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);
                node = node.getLeft();
            } else {
                node = stack.pop();
                printNode(node);
                node = node.getRight();
            }
        }
    }

    /**
     * 非递归实现后序遍历：左 - 右 - 根
     *
     * @param root
     */
    public static void normalPostOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> out = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                out.push(node);
                node = node.getRight();
            } else {
                node = stack.pop();
                node = node.getLeft();
            }
        }
        while (!out.isEmpty()) {
            System.out.println(out.pop().getVal());
        }
    }

    /**
     * 初始化树结构
     * @return 返回 root节点
     */
    private static TreeNode init() {
        TreeNode A = new TreeNode(10);
        TreeNode B = new TreeNode(6);
        TreeNode C = new TreeNode(4);
        TreeNode D = new TreeNode(8);
        TreeNode E = new TreeNode(14);
        TreeNode F = new TreeNode(12);
        TreeNode G = new TreeNode(16);
        A.left = B;
        B.left = C;
        B.right = D;
        A.right = E;
        E.left = F;
        E.right = G;
        return A;
    }
}

/**
 * TreeNode类，定义了树的结构
 */
class TreeNode{
    int val;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
