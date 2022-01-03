package com.itsnine.code.sword.simple.search;

/**
 * 长度为n-1的递增排序数组中，所有数字都是唯一的
 * 并且每个数字都在0～n-1范围内，在范围0～n-1内的n个数字中有且只有1个数字不在数组中。
 *
 * @author xu.sun
 * @create 2021-08-08-9:31 下午
 */
public class MissNum {

    /**
     * 二分查找
     * num[m] = m说明m下标前的数字是没有缺失的，左指针右移
     * 时间复杂度O(log n)
     * 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public int resolve(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }


    /**
     * 暴力破解
     * 有序数组推荐二分查找
     *
     * @param nums
     * @return
     */
    public int resolveTwo(int[] nums) {
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                return i;
            }
        }
        if (nums[0] == 0) {
            return nums.length;
        }
        return result;
    }

}
