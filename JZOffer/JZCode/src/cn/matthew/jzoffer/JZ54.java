package cn.matthew.jzoffer;

/**
 * @ClassName JZ54
 * @Description 二叉搜索树的第k大节点
 * @Author iematthew
 * @Date 2020/8/30 23:56
 * @Version 1.0
 **/

/*
题目：
给定一棵二叉搜索树，请找出其中第k大的节点。

思路：
二叉搜索树的中序遍历就是一个排序好的数组，然后直接找。
不过为了方便可以用右根左的遍历（反过来的中序遍历)。

第k小可以直接中序遍历，第k大可以反过来（不然是倒数第k个数）
 */
public class JZ54 {
    //方法已通过测试

    //全局变量统计结果
    //不放在遍历中是因为每一次递归都会reset结果，所以要放在外面
    private int res = 0;
    private int cnt = 0;

    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    //引入改造的"中序遍历"
    public void dfs(TreeNode root, int k) {
        if (root == null || k < 1) return;
        dfs(root.right, k);
        if (++cnt == k)
            res = root.val;//确定第k大的数
        dfs(root.left, k);
    }
}
