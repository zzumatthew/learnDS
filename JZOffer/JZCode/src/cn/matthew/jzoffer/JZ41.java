package cn.matthew.jzoffer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName JZ41
 * @Description 数据流中的中位数
 * @Author iematthew
 * @Date 2020/8/16 15:52
 * @Version 1.0
 **/

/*
题目：
如何得到一个数据流中的中位数？
如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

设计一个支持以下两种操作的数据结构：
    void addNum(int num) - 从数据流中添加一个整数到数据结构中
    double findMedian() - 返回目前所有元素的中位数

示例：
addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2

思路：
处理动态的数据一般不用数组，可能会用到栈、队列、二叉树、堆。
本题思路使用堆，因为堆自带排序（PriorityQueue）。
第一个堆用大根堆，第二个堆用小根堆，且大根堆中的所有数都比小根堆中的数，
为了保证能将数据平均分配到两个堆中，需要要求两个堆中的数据量的差值不超过1。

当数据流中的数据量是奇数的时候，多的那个堆中的堆顶就是符合要求的中位数。
当数据流中的数据量是偶数的时候，两个堆的堆顶求平均数就是符合要求的中位数。
 */
public class JZ41 {
    public static void main(String[] args) {
        addNum(41);
        System.out.println(findMedian());
        addNum(35);
        System.out.println(findMedian());
        addNum(62);
        System.out.println(findMedian());
        addNum(4);
        System.out.println(findMedian());
        addNum(97);
        System.out.println(findMedian());
        addNum(108);
        System.out.println(findMedian());
    }

    //两个优先队列
    static Queue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));
    static Queue<Integer> minHeap = new PriorityQueue<>();

    public static void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());//maxHeap的首个元素是最大的
        //下面的操作是让大根堆中的数据的数量不少于小根堆中的数据的数量
        //这样下一步findMedian就很容易，数量相等，取堆顶求平均数；数量不等，大根堆的堆顶弹出。
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public static double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) * 0.5;//数量相等，取堆顶求平均数
        else
            return maxHeap.peek();//数量不等，大根堆的堆顶弹出
    }
}
