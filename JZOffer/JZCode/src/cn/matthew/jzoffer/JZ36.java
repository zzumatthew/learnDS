package cn.matthew.jzoffer;

/**
 * @ClassName JZ36
 * @Description 二叉搜索树与双向链表
 * @Author iematthew
 * @Date 2020/8/14 16:38
 * @Version 1.0
 **/

/*
题目：
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
要求不能创建任何新的节点，只能调整树中节点指针的指向。
树结构
     10
    /   \
   6    14
 /  \   /  \
4   8  12  16
输出的排序的双向链表
4⇄6⇄8⇄10⇄12⇄14⇄16
(注意，剑指里面4和16没有连起来，但是leetcode里面有把4和16连起来的）

思路：
在二叉树中，每个节点都有两个指向子节点的指针。
在双向链表中，每个节点也有两个指针，分别指向前一个节点和后一个节点。
由于要求转换之后要排序，那么符合要求的遍历方式就是中序遍历（左-根-右）；
对于上述的二叉树，10应该和6节点的右节点8连起来，10应该和14节点的左子节点12连起来。
所以规律就是，根节点与左子节点的右子节点连起来，根节点与右子节点的左子节点连起来。
 */
public class JZ36 {
    public static void main(String[] args) {
        //所有的测试用例在leetcode中完成
    }

    public static TreeNode convert(TreeNode pRoot) {
        TreeNode pLastNodeInList = null;
        convertNode(pRoot, pLastNodeInList);
        TreeNode pHeadOfList = pLastNodeInList;
        while (pHeadOfList != null && pHeadOfList.left != null) {
            pHeadOfList = pHeadOfList.left;
        }
        return pHeadOfList;
    }

    private static void convertNode(TreeNode pNode, TreeNode pLastodeInList) {
        if (pNode == null)
            return;
        TreeNode pCurrent = pNode;
        if (pCurrent.left != null)
            convertNode(pCurrent.left, pLastodeInList);
        pCurrent.left = pLastodeInList;
        if (pLastodeInList != null)
            pLastodeInList.right = pCurrent;

        pLastodeInList = pCurrent;

        if (pCurrent.right != null)
            convertNode(pCurrent.right, pLastodeInList);
    }

}
