package cn.matthew.jzoffer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName JZ4002
 * @Description 最小的K个数
 * @Author iematthew
 * @Date 2020/8/16 09:57
 * @Version 1.0
 **/

/*
题目：
找出数组中的前K个最小数。

思路：
上一个做法是快速排序的翻版，但是最大的问题就是会改变给定的数组。
如果要求不能改变输入的数组，那么就需要用到其他的方法了。
leetcode思路：利用堆排序。

堆通常是一个可以被看做一棵树的数组对象。
    1.堆中某个节点的值总是不大于或不小于其父节点的值(小的排前面通常叫做小根堆，反之就是大根堆）；
      所以堆的根节点总是存着最大值或者最小值，其他的节点排序位置。
      唯一能够保证的是最小（大）的数通常在一个叶子结点，但不确定是哪一个。
    2.堆总是一棵完全二叉树。
        2.1 完全二叉树，假设树深为k，那么1-（k-1）层都是满节点，k层不一定是。
        2.2 具有n个节点的完全二叉树的深度为k = [log2(n)]向上取整
        2.3 对于一棵具有n个节点的完全二叉树，从顶开始（根为0号）分层编号，0 =< i =< n-1
            (1)如果i = 0，那么该节点为根节点
            (2)如果i > 0，那么节点i的父节点为[(i-1)/2]向下取整
            (3)如果2i+1 <= n，那么i的左孩子为2i+1，反之没有左孩子
            (4)如果2i+2 <= n，那么i的右孩子为2i+2，反之没有右孩子
        2.4 堆中支持的方法
            int size() 返回堆内元素的个数;
            int top() 返回根节点的元素;
            void push(int x) 插入一个元素;
            void pop() 将根节点元素从堆中弹出;

        PriorityQueue类在Java1.5中引入。
        我们都知道队列，队列的核心思想就是先进先出，这个优先级队列有点不太一样。
        优先级队列中，数据按关键词有序排列，
        插入新数据的时候，会自动插入到合适的位置保证队列有序。（顺序有两种形式：升序或者是降序）

【注意】
不过这个方法在leetcode上跑了21ms，击败了20%的提交。
前面的快排思想代码只跑了2ms，击败了99%；
而两者在内存使用方面几乎相同，大概40MB。
 */
public class JZ4002 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(Arrays.toString(getLeastNumsHeap(nums, 4)));
    }

    public static int[] getLeastNumsHeap(int[] nums, int k) {
        if (k == 0) return new int[0];
        //使用一个大根堆，PriorityQueue中的比较器用的降序排列
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));

        for (int num : nums) {
            if (heap.isEmpty() || heap.size() < k || num < heap.peek())
                heap.offer(num);//当前元素小于堆顶元素才会被添加
            if (heap.size() > k)
                heap.poll();//删除堆顶最大元素
        }

        //把堆中的元素存到数组中
        int[] res = new int[heap.size()];
        int j = 0;
        for (Integer num : heap) {
            res[j++] = num;
        }
        return res;
    }
}
