package cn.matthew.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Leetcode22
 * @Description 括号生成
 * @Author iematthew
 * @Date 2020/9/16 10:07
 * @Version 1.0
 **/

/*
数字n代表着生成括号的对数，设计一个函数生成所有有效的括号组合。

思路：
n = 1,()
n = 2,()(),(())
n = 3,()()(),(())(),()(()),(()()),((()))

dp[i]表示第i个数对应的结果集List<String>
转移方程 dp[i] = "(" + dp[j] + ")" + dp[k],j + k =  i - 1（从0开始算，dp[0] = "");
转移方程的意思是第i个括号括住dp[j]的结果 + dp[k]中的结果。

 */
public class Leetcode22 {
    public List<String> generateParenthesis(int n) {
        List<String>[] dp = new List[n + 1];
        List<String> dp0 = new ArrayList<String>();
        dp0.add("");
        dp[0] = dp0;

        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                int k = i - 1 - j;//前面的
                List<String> str1 = dp[j];
                List<String> str2 = dp[k];
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp[i] = cur;
        }

        return dp[n];
    }
}
