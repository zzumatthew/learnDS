package cn.matthew.jzoffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName JZ38
 * @Description 字符串的排列
 * @Author iematthew
 * @Date 2020/8/15 15:24
 * @Version 1.0
 **/

/*
题目：
输入一个字符串，打印该字符串所有的排列。
例如输入 s = "abc";
返回 ["abc","acb","bac","bca","cab","cba"].

思路：
1.先不说具体的解题思路，最重要的就是如果全排列中有重复的元素，怎么处理重复的元素？
    可以用HashSet来保存结果，HashSet不可以存储重复的元素。
2.通常这种全排列的题，都是用回溯法，JZ12就是是用的回溯法。
 */
public class JZ38 {
    public static void main(String[] args) {
        String s = "aba";
        System.out.println(Arrays.toString(permutation(s)));
    }

    static Set<String> res = new HashSet<>();

    public static String[] permutation(String s) {
        if (s == null) return new String[]{};
        boolean[] visited = new boolean[s.length()];
        dfs(s, "", visited);
        String[] result = new String[res.size()];

        return res.toArray(result);
    }

    public static void dfs(String s, String letter, boolean visited[]) {
        if (s.length() == letter.length()) {
            res.add(letter);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (visited[i]) continue;
            visited[i] = true;
            dfs(s, letter + c, visited);
            visited[i] = false;
        }
    }
}
