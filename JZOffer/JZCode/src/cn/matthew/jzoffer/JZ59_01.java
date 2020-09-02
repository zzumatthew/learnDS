package cn.matthew.jzoffer;

import java.util.LinkedList;

/**
 * @ClassName JZ59_01
 * @Description 滑动窗口的最大值
 * @Author iematthew
 * @Date 2020/9/01 22:49
 * @Version 1.0
 **/

/*
题目：
给定一个数组nums和滑动窗口的大小k，请找出所有滑动窗口的最大值。
例如 nums = {1,3,-1,-3,5,3,6,7},k = 3;
那么窗口大小为3，滑动之后记录的每一次窗内的最大值为{3,3,5,5,6,7}

思路：
1.暴力：每次找k个数里面的最大值，时间复杂度O(nk);
2.一种新的思想：单调双向队列
具体的动画见http://8nn.co/cpM8，很容易理解，但是不太好想出来的一种方法

 */
public class JZ59_01 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) return new int[0];

        int index = 0;
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {

            //为了保证队列是单调的，如果队列尾部的元素不大于当前的元素，那么就要把尾部的元素弹出
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])
                queue.pollLast();
            // 将当前的下标记录在队列中
            queue.addLast(i);

            //如果窗口已经滑过了队列中的头部元素，那么就将头部元素弹出
            if (queue.peekFirst() == (i - k))
                queue.pollFirst();

            //当窗口形成之后才能确定窗口中的最大值
            if (i >= (k - 1))
                res[index++] = nums[queue.peekFirst()];
        }

        return res;
    }
}
