package com.itsnine.code.sword.middle.sort;

import java.util.*;

/**
 * TopK问题
 *
 * @author xu.sun
 * @create 2022-01-03-2:33 下午
 */
public class TopK {

    /**
     * 堆排序
     * 时间复杂度O(nlogk) 遍历插入map 时间复杂度为O(n) 操作堆 空间复杂度为O(logk)
     * 空间复杂度O(n)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numCount = new HashMap<>(nums.length);
        //记录每个字符出现的频率
        for (int i = 0; i < nums.length; i++) {
            numCount.put(nums[i], numCount.getOrDefault(nums[i], 0) + 1);
        }

        //使用堆记录 前k个。需要实现按照次数排序
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return numCount.get(o1) - numCount.get(o2);
            }
        });
        //遍历map
        for (Integer key : numCount.keySet()) {
            //若当前堆中的size未超过k，直接加入堆中
            if (heap.size() < k) {
                heap.add(key);
            } else if (numCount.get(key) > numCount.get(heap.peek())) {
                //当前key的频率比堆顶元素的频率高时，移除堆顶元素，将当前key放入
                heap.remove();
                heap.add(key);
            }
        }
        //
        int[] result = new int[k];
        int i = k-1;
        while (!heap.isEmpty()){
            result[i] = heap.remove();
            i--;
        }
        return result;
    }
}
