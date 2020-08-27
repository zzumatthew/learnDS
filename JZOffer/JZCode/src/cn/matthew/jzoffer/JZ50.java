package cn.matthew.jzoffer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @ClassName JZ50
 * @Description 第一个只出现一次的字符
 * @Author iematthew
 * @Date 2020/8/27 16:21
 * @Version 1.0
 **/

/*
题目：
求字符串中第一个只出现一次的字符。
例如输入"abaccdeff"，则输出'b'。

思路：
肯定是要遍历整个字符串的。
变成统计字符串中各个字符出现的频率，然后找出第一个只出现一次的。
如果没有，那么返回' '.
可以变成统计字符串中字符出现的个数。

leetcode上的另一种思路就是 字符其实也是数字，比如'A' = 65.
借助数组来处理，就不用HashMap了。
 */
public class JZ50 {
    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(firstNotRepeatingChar(s));
    }

    //用HashMap统计字符出现的次数
    public static char firstNotRepeatingChar(String s) {
        if (Objects.equals(s, null)) return ' ';
        Map<Character, Integer> count = new LinkedHashMap<>();
        for (Character ch : s.toCharArray()) {
            if (count.containsKey(ch)) {
                count.put(ch, count.get(ch) + 1);
            } else {
                count.put(ch, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return ' ';
    }

    //把字符看做数组的下标，先统计字符出现的次数，再看字符是否出现一次
    public static char firstNotRepeatingCHar2(String s) {
        int[] count = new int[256];
        for (char ch : s.toCharArray()) {
            count[ch]++;
        }

        for (char ch : s.toCharArray()) {
            if (count[ch] == 1) return ch;
        }

        return ' ';
    }
}
