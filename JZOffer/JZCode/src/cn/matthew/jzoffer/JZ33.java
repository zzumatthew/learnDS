package cn.matthew.jzoffer;

/**
 * @ClassName JZ33
 * @Description 二叉搜索树的后序遍历序列
 * @Author iematthew
 * @Date 2020/8/13 18:51
 * @Version 1.0
 **/

/*
题目：
输入一个整数数组，判断该数组是不是某个二叉搜索树的后序遍历结果。
如果是，则返回true，否则就返回false。
假设输入的数组的任意两个数字都互不相同。
例如输入数组{5，7，6，9，11，10，8}，返回true；
输入数组{7,4,6,5},则由于没有这样的二叉树，所以返回false。

思路：
根据后续遍历的特点，左-右-根，那么一个数组的最后一位必然是树的根节点,
且有一部分数字比根节点小，是左子树，有一部分比根节点大，是右子树。
同理对于左右子节点都是这样的一个规律。
{7,4,6,5}为什么不是？因为5是根节点，7比5大，那么必然是在右子树上，而且这个树只有右子树，
但是又有4，不可能是右子树了。所以是矛盾的。
也就是可以用递归处理这个问题。
递归方法的本质就是比较三个节点的值，第一个小于第三个，第二个大于第三个。
递归结束的条件就是第一个节点是数组的第一个数。
 */
public class JZ33 {
    public static void main(String[] args) {
        int[] res = {5, 7, 6, 9, 11, 10, 8};
        int[] res2 = {7, 4, 6, 5};
        System.out.println(verifySeqOfBST(res));
        System.out.println(verifySeqOfBST(res2));
    }

    public static boolean verifySeqOfBST(int[] seq) {
        return verifySeqOfBST(seq, 0, seq.length - 1);
    }

    public static boolean verifySeqOfBST(int[] seq, int start, int end) {
        if (seq == null || seq.length <= 0)
            return false;

        if (start >= end)
            return true;
        //递归的本质就是判断左子树和右子树是不是真的是左子树和右子树
        //判断左子树
        int mid = start;
        while (seq[mid] < seq[end])
            mid++;
        //判断右子树
        for (int i = mid; i < end; i++) {
            if (seq[i] < seq[end])
                return false;
        }

        return verifySeqOfBST(seq, start, mid - 1) && verifySeqOfBST(seq, mid, end - 1);
    }
}
