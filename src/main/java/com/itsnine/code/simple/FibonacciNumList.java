package com.itsnine.code.simple;

import java.util.Vector;

/**
 * 斐波那契数列
 * f(0)=0
 * f(1)=1
 * f(n)=f(n-1)+f(n-2)
 *
 * 0 <= n <= 100
 * @author xu.sun
 * @create 2021-07-27-11:14 下午
 */
public class FibonacciNumList {
    //递归暴力破解，严重超时
    /**
     * 递归破解
     * 时间复杂度 O(2的n次方) 空间复杂度 O(1)
     * @param n
     * @return
     */
    public int fib(int n){
        if (n == 0 || n == 1){
            return n;
        }
       return fib(n-1)+fib(n-2);
    }


    //记忆化递归，保存计算过的斐波那契数字
    /**
     *     f(n) = f(n-1) + f(n-2)
     *     f(n-1) = f(n-2) + f(n-3),f(n-2) = f(n-3) + f(n-4)
     *     f(n-2)与f(n-3)存在重复递归计算，使用数组记录保存已经计算过的斐波那契数字
     *     采用空间换时间 时间复杂度 O(n) 空间复杂度O(n)
     */
    public int fibMemo(int n){
        //如果为n=0直接返回
        if (n == 0){
            return 0;
        }
        //开辟一个数组，记录已经计算过的斐波那契数字
        int [] memo = new int[n+1];
        memo[1] = 1;
        return caclByMemo(n,memo);

    }
    private int caclByMemo(int n, int[] memo) {
        //n=1 或 n=2 直接返回
        if (n < 2){
            return memo[n];
        }
        //数组中对于该斐波那契数字已计算过，直接返回
        if (memo[n] > 0){
            return memo[n];
        }
        //递归 int32类型是十位数，对1e9取模可防止int32溢出，1e9+7是质数，对质数取模可以尽可能的让模数避免相等
        memo[n] = (caclByMemo(n - 1,memo) + caclByMemo(n-2,memo)) % 1000000007;
        return memo[n];
    }

}
