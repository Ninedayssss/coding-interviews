package com.itsnine.code.sword.simple.search;

import java.util.HashMap;

/**
 * @author xu.sun
 * @create 2021-08-09-11:32 下午
 */
public class FirstUniqChar {
    public char resolve(String s){

        HashMap<Character, Boolean> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c,!countMap.containsKey(c));
        }
        for (char c:s.toCharArray()){
            if (countMap.get(c))
                return c;
        }
            return ' ';
    }
}
