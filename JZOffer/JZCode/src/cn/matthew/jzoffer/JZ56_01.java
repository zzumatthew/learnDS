package cn.matthew.jzoffer;

/**
 * @ClassName JZ56_01
 * @Description 数组中数字出现的次数
 * @Author iematthew
 * @Date 2020/8/31 10:42
 * @Version 1.0
 **/

/*
题目：
一个整型数组nums里除两个数字之外，其他的数字都出现了两次。
请编写程序找出这两个只出现一次的数字。
要求时间复杂度O(n)，空间复杂度O(1)。

思路：
如果只有一个数出现一次的话，那么把数组中的数逐个异或，就可以找到这个唯一出现一次的数字。
因为相同的异或为0，不同的异或为1，0与任何数异或等于这个数。
出现两次的数都异或成了0，最后就是0与唯一出现一次的数进行异或。

那么当数组中有两个数字只出现了一次的时候，还是用上面的思路的话，那么势必就需要把数组分成两个小组。
而且这两个待找的数字要分布在两个数组中。

分组的依据可以根据两个数字异或结果中1出现的位置（比如异或结果0010，那么第3位为0的分一组，第3位为1的分一组）

求1001（B）的负数
反码0110，补码 = 反码 + 1 = 0111；

1001 & 0111 = 0001，那么就可以找到最低位出现1的位置

还有一种方法就是下面这种操作，但是时间复杂度不够好。

List<Integer> list = new ArrayList<>();
for(int num:nums){
    if(list.contains(num))
        list.remove(list.indexOf(num));
    else
        list.add(num);
}

int[] res = new int[2];
res[0] = list.remove(0);
res[1] = list.remove(0);

return res;
 */
public class JZ56_01 {

    public int[] singleNums(int[] nums) {
        if (nums == null || nums.length < 1) return null;

        int sum = 0;//异或的结果
        for (int num : nums) {
            sum ^= num;
        }

        //找到异或结果中最低位出现1的位置,并且根据这个来分组
        //分完组就可以按照只有一个一次出现的数字的思路处理问题了
        int flag = sum & (-sum);

        int[] res = new int[2];
        for (int num : nums) {
            if ((flag & num) == 0)
                res[0] ^= num;
            else
                res[1] ^= num;
        }

        return res;
    }
}
