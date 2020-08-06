package cn.matthew.jzoffer;

/**
 * @description: 数组中重复的数字
 * @date: 8/6/2020
 * @author: 大帅
 * @version: 1.0
 */

/*
题目2：不修改数组找出重复的数字
在一个长度为n+1的数组里所有的数字都在1~n的范围内，所有数字中至少有一个数字是重复的。
请找出数组中任意一个重复的数字，但是不能修改输入的数组。
例如输入长度为8的数组{2,3,5,4,3,2,6,7},那么对应的输出是2或者3

思路：二分查找
把1~n的数字用中间的数字m分成两边；左边为1~m，右边为m+1~n；
如果1~m的数字在数组中出现的次数大于m，那么这个数段里面的数在数组中一定有重复的，不然应该恰好就是m
否则重复的就在另外一边；
不断的把数段进行划分就可以找到重复的数字；
 */
public class JZ0302 {
    public static void main(String[] args) {
        int[] origin = {2,3,5,4,3,2,2,7};
        int res = findRepeatNum(origin);
        System.out.println("数组中重复的数字为："+res);
    }

    private static int findRepeatNum(int[] origin) {
        //数组不合法1：数组为空或者数字里面没有数据，返回-1表示数组中没有重复的数字
        if (origin == null || origin.length <= 0) return -1;
        //数组不合法2：数组中的数字不合法，有0或者大于n+1
        for (int num : origin) {
            if (num <= 0 || num >= origin.length) return -1;
        }
        //数组是合法的
        int start = 1;
        int end = origin.length - 1;
        while (end >= start){
            int middle = ((end - start) >> 1) + start;
            int count = countRange(origin,start,middle);
            if (end == start){
                if (count > 1){
                    return start;
                }else {
                    break;
                }
            }
            //比如5~7的数字在数组中出现了超过3（7-5+1）次，那么这里面的数字必定有重复的
            if (count > middle -start + 1){
                end = middle;
            }else {
                start = middle + 1;
            }
        }
        return -1;
    }

    //求范围内的数的个数
    private static int countRange(int[] origin, int start, int end) {
        if (origin == null) return 0;
        int count = 0;
        for (int j : origin) {
            if (j >= start && j <= end) {
                count++;
            }
        }
        return count;
    }
}