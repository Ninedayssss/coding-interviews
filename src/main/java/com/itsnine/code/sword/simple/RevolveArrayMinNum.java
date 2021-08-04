package com.itsnine.code.sword.simple;

/**
 * 旋转数组的最小值
 * 旋转数组由一个或两个有序数组组成，只需找到两个数组的临界点即可
 * [1,3,5,6,0,2,4]
 * [0,0,0,2,5]
 * [0,0,0,0]
 *
 * @author xu.sun
 * @create 2021-08-01-6:51 下午
 */
public class RevolveArrayMinNum {
    /**
     * 暴力破解
     * 遍历整个数组，找出数组中最小的值
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }

    /**
     * 二分搜索解决
     * 当Left指针与Right指针重合时，说明找到了两个数组的最小节点
     * 时间复杂度O(log n) 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public int binarySearch(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // 当left = right时，退出循环
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[right] > nums[middle]) {
                // 当右指针数字大于中间指针数字时，将右指针移动到原中间指针位置[1,2,3,4,5]
                right = middle;
            } else if (nums[right] < nums[middle]) {
                // 当右指针数字小于中间指针数字，将左指针移动到原中间指针+1位置[3,4,5,1,2]
                left = middle + 1;
            } else {
                right--;
            }

        }

        return nums[left];
    }
}
