package cn.matthew.jzoffer;

/**
 * @ClassName JZ55_01
 * @Description 二叉树的深度
 * @Author iematthew
 * @Date 2020/8/31 00:31
 * @Version 1.0
 **/

/*
题目：
输入一棵二叉树的根节点，求该树的深度。
从根节点到叶节点经过的节点形成树的一条路径，最长路径的长度为树的深度。

思路：
很容易想到递归。
如果root有只有左孩子，那么depth = 1 + maxLeftDepth；
只有右孩子同理；
既有右孩子，也有左孩子，那么就是depth = 1 + max{maxLeftDepth,maxRightDepth};

而左右孩子的依旧如此计算。所以是递归最直接了当。
 */
public class JZ55_01 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int maxLeftDepth = maxDepth(root.left);
        int maxRightDepth = maxDepth(root.right);

        return maxLeftDepth > maxRightDepth ?
                (1 + maxLeftDepth) : (1 + maxRightDepth);
    }
}
