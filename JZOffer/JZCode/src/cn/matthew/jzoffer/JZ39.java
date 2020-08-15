package cn.matthew.jzoffer;

import java.util.Arrays;

/**
 * @ClassName JZ39
 * @Description 数组中出现次数超过一半的数字
 * @Author iematthew
 * @Date 2020/8/15 17:41
 * @Version 1.0
 **/

/*
题目：
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如，输入{1,2,3,2,2,2,5,4,2}。由于数字2出现5次，超过了一半。
所以输出2。

思路：
根据题目要求，如果把这个数组排序，那么需要找到的数字一定位于中间。
其实Arrays.sort()刚好有这个功能，但是真正考的应该不是这样的写法。
Arrays.sort(nums);
return nums[nums.length/2];
上面的时间复杂度是O(nlgn);

从Leetcode里面学到了一种新的算法，叫摩尔投票法。

最基本的摩尔投票问题，找出一组数字序列中出现次数大于一半数量的数。
且假设这个数字一定存在。显然，这个数字只能有一个。
摩尔投票算法是基于这个事实：每次从序列里选择两个不相同的数字删除掉（或称为“抵消”），
最后剩下一个数字或几个相同的数字，就是出现次数大于总数一半的那个。

具体例子及过程详见 https://www.zhihu.com/question/49973163

俩数字相遇，如果不一样大，同归于尽。最后活下来的数字就是超过了一半的。

以数组{1,2,3,2,2,2,5,4,2}的遍历为例：
首先major设置为0，count设置为0；
开始遍历num = 1，count == 0，所以major = 1，此时major和num一样，count = 1；
接着num = 2，major和num不等，所以两个数都死了，count = 0（没有数字活下来）
接着num = 3，count == 0，所以major = 3；此时major和num一样，count = 1；
接着num = 2，major和num不等，所以两个数都死了，count = 0；
接着num = 2，count = 0，所以major = 2，此时major和num一样，count = 1；
接着num = 2，major和num一样，所以两个数是盟友，count = 2；
接着在5和4中，会死掉两个2，count = 0；
最后活下来的数就是最后一个2！也就是出现次数超过了一半的数！

所以摩尔投票法有两个重要的指标，当前的major以及还活下来了多少个major。
最后活下来的major就是数组中个数超过了一半的！
 */
public class JZ39 {
    public static void main(String[] args) {
        //三个数组对应剑指中的三种测试用例
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] nums1 = {1};
        int[] nums2 = {1, 1, 2, 2};
        System.out.println(majorityNum(nums));
        System.out.println(majorityNum(nums1));
        System.out.println(majorityNum(nums2));
    }

    public static Integer majorityNum(int[] nums) {
        int major = 0;//表示目前还存活的数
        int count = 0;//还存活的数的个数
        for (int num : nums) {
            if (count == 0)
                major = num;//没有数字活下来，那么major就设置为被遍历到的num

            count += (major == num) ? 1 : -1;//major和num打一架，不同的话都死了
        }

        if (count > 0)
            return major;
        else
            return null;//没有数字活下来，也就是数组中没有超过半数的数字
    }
}
