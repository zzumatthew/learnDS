package cn.matthew.jzoffer;

/**
 * @ClassName JZ56_02
 * @Description 数组中数字出现的次数II
 * @Author iematthew
 * @Date 2020/8/31 17:17
 * @Version 1.0
 **/

/*
题目：
在一个数组nums中除一个数字只出现一次之外，其他数字都出现了3次。
请找出那个只出现一次的数字。

思路：
由前面的例子得到的启发，依旧是要想到位运算。
{1,2,2,2},每个数的二进制的每一位累加
0001
0010
0010
0010
-----
0031
-----
结果的每一位%3
0001 -> 1

------------
56题就是考察位运算，这方面的题做的比较少。
异或^的性质要记住的就是0异或任何一个数等于本身。

leetcode中的详细解释
https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/zhi-chu-xian-yi-ci-de-shu-xi-lie-wei-yun-suan-by-2/
 */
public class JZ56_02 {

    public int singleNum(int[] nums) throws Exception {
        if (nums.length == 0) throw new Exception("数组长度为0");

        int[] bitSum = new int[32];
        int res = 0;

        for (int num : nums) {
            int bitMask = 1;//(00000000 00000000 00000000 00000001)
            for (int i = 31; i >= 0; i--) {
                if ((num & bitMask) != 0)
                    bitSum[i]++;
                bitMask = bitMask << 1;
            }
        }

        for (int i = 0; i < 32; i++) {
            res = res << 1;
            res += bitSum[i] % 3;
        }
        return res;
    }
}
