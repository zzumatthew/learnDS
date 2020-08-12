package cn.matthew.jzoffer;

/**
 * @ClassName JZ28
 * @Description 对称的二叉树
 * @Author iematthew
 * @Date 2020/8/12 08:24
 * @Version 1.0
 **/

/*
题目：
请实现一个函数，用来判断一颗二叉树是不是对称的。
如果一个二叉树和它的镜像是一样的，那么它就是对称的，否则就不是对称的。

思路：
判断二叉树是否是对称的，其实还是二叉树的遍历。
剑指里面提供的思路比较好理解，假设我们用前序遍历（根 - 左 - 右）
那么与之对称的遍历方法应该是根 - 右 - 左；
只要这两种方法遍历出来的结果是一样的，那么就可以认为这个二叉树的对称的。
 */
public class JZ28 {
    public static void main(String[] args) {

        TreeNode a1 = new TreeNode(8);
        TreeNode a2 = new TreeNode(6);
        TreeNode a3 = new TreeNode(6);
        TreeNode a4 = new TreeNode(5);
        TreeNode a5 = new TreeNode(7);
        TreeNode a6 = new TreeNode(7);
        TreeNode a7 = new TreeNode(5);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = a6;
        a3.right = null;
        System.out.println(isSymmetrical(a1));
    }

    public static boolean isSymmetrical(TreeNode root) {
        return isSymmetrical(root, root);
    }

    //递归判断两个节点是否对称，
    //node1.left.val == node2.right.val && node1.right.val == node2.left.val
    public static boolean isSymmetrical(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;

        return isSymmetrical(node1.left, node2.right)
                && isSymmetrical(node1.right, node2.left);
    }
}
