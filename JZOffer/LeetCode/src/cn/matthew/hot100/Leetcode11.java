package cn.matthew.hot100;

/**
 * @ClassName Leetcode11
 * @Description 装水最多的容器
 * @Author iematthew
 * @Date 2020/9/15 17:28
 * @Version 1.0
 **/

/*
思路：
定义两个指针，i从头开始，j从尾开始
由于装的水取决于最低的板子，所以哪一边低那边就走，装的水 = 距离 * 低的板子
 */
public class Leetcode11 {
    public int maxArea(int[] height) {
        int i = 0;//负责递增
        int j = height.length - 1;//负责递减
        int res = minTimes(height[i], height[j], i, j);
        while (i < j) {
            int front = height[i];
            int back = height[j];
            res = Math.max(res, minTimes(front, back, i, j));
            //哪一边低那边就走
            if (front < back) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public int minTimes(int n1, int n2, int fr, int bc) {
        //两个板子之间的距离
        int gap = bc - fr;
        return n1 < n2 ? n1 * gap : n2 * gap;
    }
}
