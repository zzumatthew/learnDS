package cn.matthew.jzoffer;

import java.util.Arrays;

/**
 * @description: 数组的合并并排序
 * @date: 8/6/2020
 * @author: 大帅
 * @version:
 */

/*
JZ05的相关题目：
有两个排序的数组A1和A2，内存在A1的末尾有足够多的空余空间容纳A2。
请实现一个函数，把A2中的所有数字插入A1中，并且所有的数字都是排好序的。

输入
A1 = {1,2,4,6};
A1 = {1,3,6,9};
输出
A3 = {1,1,2,3,4,6,6,9}

思路
不要暴力求解！
可以先创建一个新的数组，将两个数组倒序处理，大的数排后面，小的数排前面

 */
public class JZ0502 {
    public static void main(String[] args) {
        int[] a1 = {0,2,4,6};
        int[] a2 = {1,3,7,9};
        int[] a3 = arrayCombine(a1,a2);
        System.out.println(Arrays.toString(a3));
    }

    /**
     * 合并两个有序数组并使之有序
     * @param a1 第一个数组
     * @param a2 第二个数组
     * @return 输出合并之后的有序数组
     */
    private static int[] arrayCombine(int[] a1, int[] a2) {
        //输入的数组都为空
        if (a1 == null || a2 == null) return null;
        //输入的数组不全为空
        int length1 = a1.length;
        int length2 = a2.length;
        if (length1 == 0 && length2 != 0){
            return a2;
        }else if (length1 != 0 && length2 == 0){
            return a1;
        }else {
            int[] a3 = new int[length1+length2];
            int p1 = length1 - 1;
            int p2 = length2 - 1;
            int p3 = length1 + length2 - 1;
            while (p1 >= 0 && p2 >= 0){
                //首先把第一个元素取出来放好
                a3[0] = Math.min(a1[0], a2[0]);
                //倒序处理其他位置的元素
                if (a1[p1] >= a2[p2]){
                    a3[p3--] = a1[p1--];
                }else {
                    a3[p3--] = a2[p2--];
                }
            }
            return a3;
        }
    }
}
