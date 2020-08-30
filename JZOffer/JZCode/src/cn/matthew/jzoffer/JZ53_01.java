package cn.matthew.jzoffer;

/**
 * @ClassName JZ53
 * @Description 在排序数组中查找数字
 * @Author iematthew
 * @Date 2020/8/30 10:02
 * @Version 1.0
 **/

/*
题目：
统计一个数字在排序数组中出现的次数。例如输入排序数组{1,2,3,3,3,4,5}和数字3。
由于3在数组中出现了4次，那么输出4。
 */
public class JZ53_01 {
    public static void main(String[] args) {
        //方法已经通过测试
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        return binarySearch(nums, target + 0.5) - binarySearch(nums, target - 0.5);
    }

    /**
     * 二分查找target+0.5和target-0.5的下边界
     *
     * @param nums
     * @param target
     * @return
     */
    private static int binarySearch(int[] nums, double target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return low;
    }
}
