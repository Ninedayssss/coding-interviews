package com.itsnine.code.sword.simple.search;

/**
 * 寻找数组中重复出现的数字次数
 *
 * @author xu.sun
 * @create 2021-08-08-9:05 下午
 */
public class SearchRepeatNumCount {

    /**
     * 暴力破解
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param array
     * @param target
     * @return
     */
    public int resolveOne(int[] array, int target) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                count++;
            }
        }

        return count;
    }

    /**
     * 二分查找，分别查找出左右边界
     * 计算左右边界差即可
     * 时间复杂度O(log n)
     * 空间复杂度O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int resolveTwo(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i;
        if (j >= 0 && nums[j] != target) return 0;

        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;
        return right - left - 1;
    }


    /**
     * 简化写法
     * 原理仍未二分查找
     * 取巧：由于是递增数组，只需找出target的右边界与target-1的右边界相减即可
     *
     * @param nums
     * @param target
     * @return
     */
    public int resolveThree(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    public int helper(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
