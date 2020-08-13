package cn.matthew.jzoffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName JZ3201
 * @Description 从上到下打印二叉树
 * @Author iematthew
 * @Date 2020/8/12 22:41
 * @Version 1.0
 **/

/*
题目：
不分行从上到下打印二叉树。
从上到下打印二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
例如一个二叉树的结构如下所示
   8
  / \
 6   10
/ \  / \
5 7 9  11

按照题目的意思应该是依次打印输出8,6,10,5,7,9,11

思路：
这道题实质上考的是树的遍历（但是不是常见的三种遍历方式）
因为按层打印的顺序决定应该先打印根节点，所以从树的根节点开始。
根节点8的两个子节点6和10应该都保存在一个容器里面;
打印完6之后，6的两个子节点5和7需要进入到容器；
同理打印完10之后，10的两个子节点9和11需要进入容器。
接着一次打印5 7 9 11
所以可以看到先进入容器的先打印，容器就是队列！
 */
public class JZ3201 {
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
        System.out.println(Arrays.toString(printTreeFromTop(t1)));
    }

    public static int[] printTreeFromTop(TreeNode root) {
        if (root == null) return new int[0];
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        queue.offerLast(root);
        TreeNode node = null;
        while (queue.size() != 0) {
            node = queue.pollFirst();
            list.offer(node.val);

            if (node.left != null) {
                queue.offerLast(node.left);
            }

            if (node.right != null) {
                queue.offerLast(node.right);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
