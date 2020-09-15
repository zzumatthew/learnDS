package cn.matthew.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Leetcode17
 * @Description 字符串的组合问题
 * @Author iematthew
 * @Date 2020/9/15 20:19
 * @Version 1.0
 **/

/*

 */
public class Leetcode17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() <= 0) return res;

        List<String> digitsCharList = getCharList(digits.charAt(0));
        if (digits.length() == 1) return digitsCharList;

        //递归
        List<String> last = letterCombinations(digits.substring(1));
        for (String digitStr : digitsCharList) {
            for (int i = 0; i < last.size(); i++) {
                res.add(digitStr + last.get(i));
            }
        }

        return res;
    }

    public List<String> getCharList(char c) {
        switch (c) {
            case '2':
                return Arrays.asList("a", "b", "c");
            case '3':
                return Arrays.asList("d", "e", "f");
            case '4':
                return Arrays.asList("g", "h", "i");
            case '5':
                return Arrays.asList("j", "k", "l");
            case '6':
                return Arrays.asList("m", "n", "o");
            case '7':
                return Arrays.asList("p", "q", "r", "s");
            case '8':
                return Arrays.asList("t", "u", "v");
            case '9':
                return Arrays.asList("w", "x", "y", "z");
            default:
                return new ArrayList<>();
        }
    }
}
