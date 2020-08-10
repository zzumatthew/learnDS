package cn.matthew.jzoffer;
/**
 * @description: 二叉树的下一个节点
 * @date: 8/6/2020
 * @author: 大帅
 * @version:
 */

/*
题目：
给定一棵二叉树和其中一个节点，如何找出中序遍历序列的下一个节点？
树中的节点除了有两个分别指向左右节点的指针，还有一个指向父节点的指针。

思路：
在中序遍历中，如果一个节点有右子树，那么它的下一个节点就是右子树的最左节点。
如果这个节点是其父节点的左子节点，那么它的下一个节点就是父节点；
如果一个节点既没有右子树，而且也不是父节点的左子节点，那么可以沿着指向父节点的指针一直向上遍历，直到找到一个是它父节点的左子节点的节点
如果这样的节点存在，那么其父节点就是要找的下一个节点；如果不存在，那么下一个节点就没有。

启发：
对于这种树结构的，可以画图找规律，一般看肯定是看不出规律的。找到了规律就可以分类讨论了。
 */
public class JZ08 {
    public static void main(String[] args) {
        System.out.println("中序遍历结果");
        inOrder(init()[0]);
        System.out.printf("\n节点%s的下一个节点是%s",
                init()[1].getVal(),findNextNode(init()[0],init()[1]).getVal());
    }

    private static void printNode(TreeNodeString treeNode){
        System.out.print(treeNode.getVal() + " ");
    }

    public static void inOrder(TreeNodeString root){
        if (root.getLeft() != null) inOrder(root.getLeft());
        printNode(root);
        if (root.getRight() != null) inOrder(root.getRight());
    }

    /**
     * 找到target节点的下一个节点
     * @param root 二叉树的根节点
     * @param target 目标节点
     * @return 目标节点的下一个节点
     */
    public static TreeNodeString findNextNode(TreeNodeString root,TreeNodeString target){
        //排除不合理的情况
        if (root == null || target == null) {
            return null;
        }
        //1.如果target节点有右子树，那么它的下一个节点就是右子树的最左节点。
        if (target.right != null){
            target = target.right;
            while (target.left != null) target = target.left;
            return target;
        }
        //2.如果这个节点是其父节点的左子节点，那么它的下一个节点就是父节点；
        if (target.parent != null && target == target.parent.left)
            return target.parent;//父节点是下一个节点

        //3.如果一个节点既没有右子树，而且也不是父节点的左子节点，那么可以沿着指向父节点的指针一直向上遍历
        //  直到找到一个是它父节点的左子节点的节点，如果这样的节点存在，那么其父节点就是要找的下一个节点；
        //  如果不存在，那么下一个节点就没有。
        if (target != target.parent.left){
            TreeNodeString temp = target.parent;
            while (temp != null){
                if (target == temp.left){
                    return temp;//一个节点是其父节点的左节点，那么父节点就是下一个节点
                }else {
                    target = temp;
                    temp = temp.parent;//沿着父节点的指针一直向上找
                }
            }
        }
        return null;
    }

    /**
     * 树结构的初始化
     * @return 返回值的第一个代表根节点，第二个代表目标节点
     */
    public static TreeNodeString[] init(){
        TreeNodeString A = new TreeNodeString("a");//A是所给定二叉树的root节点
        TreeNodeString B = new TreeNodeString("b");
        TreeNodeString C = new TreeNodeString("c");
        TreeNodeString D = new TreeNodeString("d");
        TreeNodeString E = new TreeNodeString("e");
        TreeNodeString F = new TreeNodeString("f");
        TreeNodeString G = new TreeNodeString("g");
        TreeNodeString H = new TreeNodeString("h");
        TreeNodeString I = new TreeNodeString("i");
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = H;
        E.right = I;
        C.left = F;
        C.right = G;
        B.parent = A;
        C.parent = A;
        D.parent = B;
        E.parent = B;
        H.parent = E;
        I.parent = E;
        F.parent = C;
        G.parent = C;

        return new TreeNodeString[]{A, I};
    }

}
class TreeNodeString{
    String val;
    TreeNodeString left = null;
    TreeNodeString right = null;
    TreeNodeString parent = null;

    public TreeNodeString(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public TreeNodeString getLeft() {
        return left;
    }

    public void setLeft(TreeNodeString left) {
        this.left = left;
    }

    public TreeNodeString getRight() {
        return right;
    }

    public void setRight(TreeNodeString right) {
        this.right = right;
    }

    public TreeNodeString getParent() {
        return parent;
    }

    public void setParent(TreeNodeString parent) {
        this.parent = parent;
    }
}