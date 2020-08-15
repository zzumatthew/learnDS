package cn.matthew.jzoffer;

/**
 * @ClassName JZ37
 * @Description 序列化二叉树
 * @Author iematthew
 * @Date 2020/8/15 09:34
 * @Version 1.0
 **/

/*
题目：
请实现两个函数，分别用来序列化和反序列化二叉树。

思路：
根据提供的测试用例
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
两个方法应该是两个可逆的函数。所以序列化的时候要选择合适的遍历方式（序列化的过程就是要遍历）
序列化一棵二叉树，
 */
public class JZ37 {
    public static void main(String[] args) {
        // 测试用例为leetcode的测试用例
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("原始树：" + root);
        String result = serialize(root);
        System.out.println("序列化结果：" + result);
        TreeNode deserializeRoot = deserialize(result);
        System.out.println("反序列后的树：" + deserializeRoot);
    }

    // 序列化一棵二叉树
    public static String serialize(TreeNode root) {
        if (root == null) return "$,";
        StringBuilder res = new StringBuilder();
        res.append(root.val);
        res.append(",");
        res.append(serialize(root.left));
        res.append(serialize(root.right));
        return res.toString();
    }

    //反序列化一棵二叉树
    public static TreeNode deserialize(String data) {
        StringBuilder stringBuilder = new StringBuilder(data);
        return deserializeCore(stringBuilder);
    }

    public static TreeNode deserializeCore(StringBuilder stringBuilder) {
        if (stringBuilder.length() == 0) return null;
        String num = stringBuilder.substring(0, stringBuilder.indexOf(","));
        stringBuilder.delete(0, stringBuilder.indexOf(","));
        stringBuilder.deleteCharAt(0);
        if (num.equals("$"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(num));
        node.left = deserializeCore(stringBuilder);
        node.right = deserializeCore(stringBuilder);
        return node;
    }

}
