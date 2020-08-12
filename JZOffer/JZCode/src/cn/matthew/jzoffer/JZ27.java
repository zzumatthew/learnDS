package cn.matthew.jzoffer;

/**
 * @ClassName JZ27
 * @Description 二叉树的镜像
 * @Author iematthew
 * @Date 2020/8/12 08:03
 * @Version 1.0
 **/

/*
题目：
请完成一个函数，输入一颗二叉树，这个函数输出二叉树的镜像。

思路：
二叉树的镜像规律就是 根节点不动，左右节点互换位置。
所以可以用递归来解决，递归的本质就在于把左子节点和右子节点互相交换位置。
还要考虑其他null的情况。
 */
public class JZ27 {
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(8);
        TreeNode a2 = new TreeNode(6);
        TreeNode a3 = new TreeNode(10);
        TreeNode a4 = new TreeNode(5);
        TreeNode a5 = new TreeNode(7);
        TreeNode a6 = new TreeNode(9);
        TreeNode a7 = new TreeNode(11);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = a6;
        a3.right = a7;
        //根-左-右遍历原树，输出8 6 5 7 10 9 11
        System.out.println("原像前序遍历输出");
        JZ0702.preOrder(a1);
        //根-左-右遍历镜像树，预期输出8 10 11 9 6 7 5
        System.out.println();
        System.out.println("镜像前序遍历输出");
        JZ0702.preOrder(mirrorTree(a1));
    }

    //递归实现树的镜像
    public static TreeNode mirrorTree(TreeNode pNode) {
        if (pNode == null) return null;
        if (pNode.left == null && pNode.right == null)
            return pNode;

        //递归方法本质在干嘛？就是把左子节点和右子节点进行交换！
        TreeNode pTemp = pNode.left;
        pNode.left = pNode.right;
        pNode.right = pTemp;

        if (pNode.left != null)
            mirrorTree(pNode.left);
        if (pNode.right != null)
            mirrorTree(pNode.right);

        return pNode;
    }
}
