package cn.matthew.jzoffer;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName JZ34
 * @Description 二叉树中和为某一个值的路径
 * @Author iematthew
 * @Date 2020/8/14 09:16
 * @Version 1.0
 **/

/*
题目：
输入一颗二叉树和一个整数，打印出二叉树中节点知的和为输入整数的所有路径。
从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
例如给定二叉树以及目标 sum = 22
          5
         / |
        4  8
       /  / |
      11 13 4
     / \   / \
    7  2  5   1
返回[
    [5,4,11,2],
    [5,8,4,5]
   ]

思路：
寻找路径，本质上其实还是树的遍历（所以说三种遍历方式的6种实现也很重要）。
可以发现，要寻找的路径都是从根节点开始的，在三种遍历方式种只有前序遍历是从根节点开始的。
先访问5，接着访问4，接着11，接着7，和不为22，不符合条件。
11有右子树，还要继续验证5 4 11 2，和为22，符合。

 */
public class JZ34 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(11);
        TreeNode t5 = new TreeNode(13);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(2);
        TreeNode t9 = new TreeNode(5);
        TreeNode t10 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;
        t3.right = t6;
        t4.left = t7;
        t4.right = t8;
        t6.left = t9;
        t6.right = t10;
        List<List<Integer>> results = pathSum(t1, 22);
        for (List<Integer> result : results) {
            System.out.println(result);
        }
    }

    static LinkedList<List<Integer>> res = new LinkedList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    private static void recur(TreeNode root, int sum) {
        if (root == null) return;
        path.add(root.val);//前序遍历，先打印根节点
        sum -= root.val;
        //当满足以下条件的时候才把节点加入进去
        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }
        recur(root.left, sum);
        recur(root.right, sum);
        path.removeLast();//向上回溯，目的是遍历完所有符合条件的路径(好好回顾树的前序遍历）
    }
}
