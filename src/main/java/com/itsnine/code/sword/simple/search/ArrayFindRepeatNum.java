package com.itsnine.code.sword.simple.search;

import java.util.HashMap;

/**
 * 寻找数组中重复的数字
 * @author xu.sun
 * @create 2021-07-29-10:19 下午
 */
public class ArrayFindRepeatNum {
    public int findNum(int[] nums){
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            if (numMap.containsKey(num)){
                return num;
            }
            numMap.put(num,num);
        }
        return -1;
    }
}
