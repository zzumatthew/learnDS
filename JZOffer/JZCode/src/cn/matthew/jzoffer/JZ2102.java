package cn.matthew.jzoffer;

import java.util.Arrays;

/**
 * @ClassName JZ2102
 * @Description JZ21可扩展改写
 * @Author iematthew
 * @Date 2020/8/10 17:44
 * @Version 1.0
 **/

/*
现在需要将JZ21的代码改写，使得更好的扩展。
比如能被3整除和不能被3整除的；
正数和负数；

启发：
在整个大的框架下，发现排序的标准是核心，所以可以将排序的标准剥离出来。
灵活的逻辑可以考虑解耦。同时可以增强整体代码的鲁棒性！
 */
public class JZ2102 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(reorder(nums)));
    }

    //数据交换
    public static int[] reorder(int[] nums) {
        if (nums == null && nums.length == 0) return null;

        int p1 = 0;
        int p2 = nums.length - 1;
        int temp;

        while (p1 < p2) {
            while (p1 < p2 && !fun(nums[p1]))
                p1++;

            while (p1 < p2 && fun(nums[p2]))
                p2--;

            //数据交换
            temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
        }
        return nums;
    }

    //数据交换的条件（解耦，以后只需要改条件就行，条件为true的放后面）
    public static boolean fun(int i) {
        //return (i % 3) == 0;//这个条件可以将能被3整除的放后面
        return (i % 2) == 0;//这个条件可以将偶数放在后面
    }
}
