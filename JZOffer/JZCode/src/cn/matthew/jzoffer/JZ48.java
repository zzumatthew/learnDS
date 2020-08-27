package cn.matthew.jzoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JZ48
 * @Description 最长不含重复字符的子字符串
 * @Author iematthew
 * @Date 2020/8/26 21:25
 * @Version 1.0
 **/

/*
题目：
请从字符串中找到一个最长不包含重复字符的子字符串，计算该最长子字符串的长度。
假设字符串中只包含'a'-'z'的字符。
例如在字符串"arabcacfr"中，最长不包含重复字符的子字符串为"acfr"，长度为4。

思路：
剑指中提供的思路还是用DP。
使用暴力求解复杂度高到O(n^3)!

1.设计状态
    设动态规划列表dp，dp[j]为以字符s[j]为结尾的最长不重复字符的子字符串的长度。
2.状态转移方程
    2.1 当s[j]没有出现过的时候，dp[j] = dp[j-1] + 1;
    2.2 当s[j]之前出现过，记d = j - i，即两次出现的距离
        2.2.1 d > dp[j-1]说明不止出现一次，在计算之前的时候也重复了，那么dp[j] = dp[j-1] + 1成立；
        2.2.2 d <= dp[j-1] 说明在dp[j-1]里面重复了，那么dp[j-1]就需要切断，此时dp[j] = d;
3.计算顺序，由小到大


 */
public class JZ48 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("arabcacfr"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0;
        int tmp = 0;
        for (int j = 0; j < s.length(); ++j) {
            int i = dic.getOrDefault(s.charAt(j), -1);
            dic.put(s.charAt(j), j);//更新字符出现的位置
            tmp = tmp < j - i ? tmp + 1 : j - i;//状态转移方程的合并写法
            res = Math.max(tmp, res);
        }
        return res;
    }
}
