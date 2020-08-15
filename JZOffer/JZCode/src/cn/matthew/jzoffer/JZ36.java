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
4⇄6⇄8⇄10⇄12⇄14⇄16(其实这个顺序就是中序遍历的顺序，所以中序遍历的结果中的数已经排好序了）
(注意，剑指里面4和16没有连起来，但是leetcode里面有把4和16连起来的）

思路：
在二叉树中，每个节点都有两个指向子节点的指针。
在双向链表中，每个节点也有两个指针，分别指向前一个节点和后一个节点。
由于要求转换之后要排序，那么符合要求的遍历方式就是中序遍历（左-根-右）；
对于上述的二叉树，10应该和6节点的右节点8连起来，10应该和14节点的左子节点12连起来。
所以规律就是，根节点与左子节点的右子节点连起来，根节点与右子节点的左子节点连起来。

另外一个写法就是先把中序遍历的结果保存在一个List中，然后一个一个取，互相指认关系.
这个写法比较容易理解，但是在leetcode里面跑的结果排名太低。（执行时间和内存消耗都只击败了不到20%）
 */
public class JZ36 {
    public static void main(String[] args) {
        //所有的测试用例在leetcode中完成
    }

    static TreeNode pre = null;
    static TreeNode head = null;

    //完成树到双向列表的转换，整个操作用到了三个"指针" 当前cur，上一个pre，第一个head
    public static TreeNode treeToDoubleList(TreeNode root) {
        if (root == null) return root;
        helper(root);//得到一个双向链表
        //首尾相连形成一个循环链表
        head.left = pre;
        pre.right = head;
        return head;
    }

    //cur是当前节点，pre是上一轮的cur(其实就是在进行中序遍历）
    public static void helper(TreeNode cur) {
        if (cur == null) return;
        //找左节点，找不到就返回
        helper(cur.left);
        //构建链表，当前的左边是上一个，上一个的右边是当前
        if (pre != null) {
            cur.left = pre;
            pre.right = cur;
        } else {
            head = cur;//这个在整个程序中只会执行一次，用于找到头节点（树最左边的一个节点）
        }
        pre = cur;
        //找右节点，找不到就返回
        helper(cur.right);
    }
}
