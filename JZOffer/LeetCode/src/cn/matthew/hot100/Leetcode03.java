package cn.matthew.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Leetcode03
 * @Description 无重复的字符串
 * @Author iematthew
 * @Date 2020/9/13 10:51
 * @Version 1.0
 **/

/*
给定一个字符串，找出其中不含有重复字符串的最大的长度
 */
public class Leetcode03 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;

        int len = s.length();
        int pL = 0;//滑动窗口的左指针
        int pR = 0;//滑动窗口的右指针
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (pL = 0; pL < len; pL++) {
            if (pL != 0) set.remove(s.charAt(pL - 1));

            while (pR < len && !set.contains(s.charAt(pR))) {
                set.add(s.charAt(pR++));
            }

            res = Math.max(res, pR - pL);

        }

        return res;
    }
}
