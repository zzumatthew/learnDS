package cn.matthew.jzoffer;

/**
 * @ClassName JZ55_02
 * @Description 平衡二叉树
 * @Author iematthew
 * @Date 2020/8/31 00:50
 * @Version 1.0
 **/

/*
题目：
输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
如果任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

思路：
有了上一道题的思路，其中一种解决方案就是，每次遍历一个节点都判断maxLeftDepth
和maxRightDepth的长度关系。
 */
public class JZ55_02 {
    //方法已通过测试
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (!isBalanced(root.left)) return false;
        if (!isBalanced(root.right)) return false;

        int maxLeftDepth = maxDepth(root.left);
        int maxRightDepth = maxDepth(root.right);
        if (Math.abs(maxLeftDepth - maxRightDepth) > 1)
            return false;

        return true;
    }

    //JZ55_01的代码
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int maxLeftDepth = maxDepth(root.left);
        int maxRightDepth = maxDepth(root.right);

        return maxLeftDepth > maxRightDepth ?
                (1 + maxLeftDepth) : (1 + maxRightDepth);
    }
}
