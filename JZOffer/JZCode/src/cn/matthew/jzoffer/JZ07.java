package cn.matthew.jzoffer;


/**
 * @description: 重建二叉树
 * @date: 8/6/2020
 * @author: 大帅
 * @version:
 */

/*
题目：
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
假设输入的前序遍历和中序遍历的结果都不包含重复的数字。
例如，输入的前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,6,8}。

在二叉树的前序遍历中，根节点总是在第一个数字，从前序遍历的结果中可以很快的获取到根节点
但是在中序遍历中，根节点的值在序列的中间，左子树的节点的值位于根节点的值得左边；
而右子树的节点的值位于根节点的值得右边。
 */
public class JZ07 {
    public static void main(String[] args) throws Exception {
      preOrderTraverse((reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8},new int[]{4,7,2,1,5,3,8,6})));
    }


    public static TreeNode reConstructBinaryTree(int[] pre,int[] in) throws Exception {
        if (pre == null || in == null || pre.length <= 0 || in.length <=0 || pre.length != in.length){
            throw new Exception("输入的遍历结果不合理！");
        }
        return construct(pre,in,0,pre.length - 1,0,in.length - 1);
    }

    /**
     *
     * @param pre 输入的前序遍历的结果
     * @param in 输入的中序遍历的结果
     * @param pStart 前序序列开始位置
     * @param pEnd 前序序列的结束位置
     * @param iStart 中序序列的开始位置
     * @param iEnd 中序序列的结束位置
     * @return
     */
    private static TreeNode construct(int[] pre, int[] in, int pStart, int pEnd, int iStart, int iEnd) throws Exception {
        TreeNode root = new TreeNode(pre[pStart]);
        //输入的两个数组都只有一个数
        if (pStart == pEnd && iStart == iEnd){
            if (pre[pStart] != in[iStart]){
                throw new Exception("输入的数组不符合规定！");
            }
            return root;
        }

        int index = iStart;
        while (root.val != in[index] && index <= iEnd){
            index++;
        }
        if (index > iEnd){
            throw new Exception("输入的数组不符合规定！");
        }
        int leftLength = index - iStart;
        if (leftLength > 0){
            root.left = construct(pre,in,pStart+1,pStart+leftLength,iStart,index-1);
        }
        if (leftLength < iEnd - iStart){
            root.right = construct(pre,in,pStart+leftLength+1,pEnd,index+1,iEnd);
        }
        return root;
    }

    private static void preOrderTraverse(TreeNode node){
        if (node == null) return;
        System.out.print(node.val);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    private static void inOrderTraverse(TreeNode node){
        if (node == null) return;
        inOrderTraverse(node.left);
        System.out.print(node.val);
        inOrderTraverse(node.right);
    }

}

