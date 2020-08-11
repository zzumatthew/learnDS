package cn.matthew.jzoffer;

/**
 * @ClassName JZ26
 * @Description 树的子结构
 * @Author iematthew
 * @Date 2020/8/11 22:06
 * @Version 1.0
 **/

/*
题目：
输入两颗二叉树A和B，判断B是不是A的子结构。

思路：
整个过程需要分两步
第一步：需要在A中找到B的根节点（找不到肯定就不是子树）；
第二步：需要检查左子节点和右子节点。

都用了递归的方法，好好再理解一下递归！不要跳进递归！
注意理解递归函数的本质是在做什么！
 */
public class JZ26 {
    public static void main(String[] args) {
        //A树
        TreeNode a1 = new TreeNode(8);
        TreeNode a2 = new TreeNode(8);
        TreeNode a3 = new TreeNode(7);
        TreeNode a4 = new TreeNode(9);
        TreeNode a5 = new TreeNode(2);
        TreeNode a6 = new TreeNode(4);
        TreeNode a7 = new TreeNode(7);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a5.left = a6;
        a5.right = a7;
        //B树
        TreeNode b1 = a1;
        TreeNode b2 = a4;
        TreeNode b3 = a5;
        b1.left = b2;
        b1.right = b3;

        System.out.println(hasSubTree(a1, b1));
    }

    /**
     * 判断A树是否包含B树
     *
     * @param rootA A树的根
     * @param rootB B树的根
     * @return 布尔值
     */
    public static boolean hasSubTree(TreeNode rootA, TreeNode rootB) {
        if (rootA == null || rootB == null)
            return false;

        return doesTreeAHasTreeB(rootA, rootB)
                || hasSubTree(rootA.left, rootB)
                || hasSubTree(rootA.right, rootB);
    }

    /**
     * 判断节点的数值是否相等
     *
     * @param root1 第一个节点
     * @param root2 第二个节点
     * @return 布尔值
     */
    public static boolean doesTreeAHasTreeB(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val != root2.val) return false;

        return doesTreeAHasTreeB(root1.left, root2.left)
                && doesTreeAHasTreeB(root1.right, root2.right);
    }
}
