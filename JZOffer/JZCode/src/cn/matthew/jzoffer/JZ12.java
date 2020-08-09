package cn.matthew.jzoffer;

/**
 * @description: 矩阵中的路径
 * @date: 8/7/2020
 * @author: 大帅
 * @version:
 */

/*
题目：
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。

输入：
a b t g
c f c s
j d e h;

bfce存在

思路：
回溯法是一种选优搜索法，又称为试探法，按选优条件向前搜索，以达到目标。
但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，
满足回溯条件的某个状态的点称为“回溯点”。
用回溯法的时候只需要关注三点：路径、选择列表和结束条件

当矩阵中坐标为（row，col）的格子和路径字符串中下标为pathLength的字符一样时，
从4个相邻的格子（row，col-1）、（row，col+1）、（row-1，col）、（row+1，col）
去定位下标为pathLength+1的字符。
如果附近的4个格子都没有要找的字符，那说明下标为pathLength的字符串定位不正确
需要重新回到pathLength-1的字符串重新定位。
重复这个过程直到路径字符串中的每一个字符都在矩阵中找到合适的位置。

 */
public class JZ12 {
    public static void main(String[] args) {
        char[] chMatrix = "abtgcfcsjdeh".toCharArray();
        int rows = 3;
        int cloumns = 4;
        char[] str = "bfce".toCharArray();
        if (hasPath(chMatrix, rows, cloumns, str)) {
            System.out.println("Yes！");
        } else {
            System.out.println("No!");
        }
    }

    /**
     * 矩阵chMatrix中是否存在包含str的路径
     *
     * @param chMatrix 字符矩阵
     * @param rows     矩阵行
     * @param columns  矩阵列
     * @param str      目标字符串
     * @return 判断结果
     */
    public static boolean hasPath(char[] chMatrix, int rows, int columns, char[] str) {
        //排除不合理的情况
        if (chMatrix == null || rows < 1 || columns < 1 || str == null)
            return false;

        //定义与chMatrix一样大的布尔矩阵用于记录该方格是否被访问过
        boolean[] isVisited = new boolean[rows * columns];

        //注意（row，col）的元素在数组中的下标为row * columns + col；
        int pathLength = 0;//pathLength表示路径字符串的下标
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (hasPathCore(chMatrix, rows, columns, row, col, str, pathLength, isVisited)) {
                    return true;
                }
            }
        }
        return false;//跑完了还没有被if中的return说明不存在这条路径，返回false
    }

    public static boolean hasPathCore(char[] chMatrix, int rows, int columns, int row, int col, char[] str, int pathLength, boolean[] isVisited) {
        if (row < 0 || col < 0 || row > rows || isVisited[row * columns + col] || str[pathLength] != chMatrix[row * columns + col])
            return false;
        //路径长度和字符串的长度一样，说明路径字符在矩阵中都找都了合适的位置，也就是矩阵中存在需要找的字符串
        if (pathLength == str.length - 1)
            return true;
        //从（row，col）四周的四个方格中找下标为pathLength+1的字符，且（row，col）这个字符已经被访问
        boolean hasPath;//判断附近的四个方格中是否有下一个需要找的字符
        isVisited[row * columns + col] = true;
        hasPath = hasPathCore(chMatrix, rows, columns, row - 1, col, str, pathLength + 1, isVisited)
                || hasPathCore(chMatrix, rows, columns, row + 1, col, str, pathLength + 1, isVisited)
                || hasPathCore(chMatrix, rows, columns, row, col - 1, str, pathLength + 1, isVisited)
                || hasPathCore(chMatrix, rows, columns, row, col + 1, str, pathLength + 1, isVisited);

        //如果四周的四个方格中没有要找的下一个字符，说明pathLength这个字符在矩阵中的定位有问题，需要回到上一个
        //同时（row，col）要重新设置为没有被访问的状态
        if (!hasPath) {
            --pathLength;
            isVisited[row * columns + col] = false;
        }
        return hasPath;
    }
}
