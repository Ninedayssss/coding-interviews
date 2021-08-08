package com.itsnine.code.sword.simple.dp;

/**
 * 青蛙跳台阶
 *
 * @author xu.sun
 * @create 2021-07-29-11:01 下午
 */
public class ClimbingStairs {
    /**
     * 青蛙一次可以跳1级台阶也可以跳2级台阶，一共有n级台阶，共有多少中跳法
     *
     * <p>
     * 跳n级台阶可看作f(n)
     * 第一次跳有两种选择：
     * 跳1级，后面剩下n-1级台阶，可看作f(n-1)
     * 跳2级，后面剩下n-2级台阶，可看作f(n-2)
     * f(n)=f(n-1)+f(n-2)
     * 时间复杂度：O(n) 空间复杂度：O(1)
     * </p>
     *
     * @param n
     * @return
     */
    public int numWays1(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int n1 = 1;
        int n2 = 2;
        int sum = 0;
        for (int i = 2; i < n; i++) {
            sum = (n1 + n2) % 1000000007;
            n1 = n2;
            n2 = sum;
        }
        return sum;
    }

    /**
     * 青蛙跳台阶，一次可以跳1级，一次也可以跳n级，共有n级台阶，共多少中跳法
     * 跳n级台阶的跳法可以看作f(n)
     * <p>
     * 当第一次跳1级，后面剩下n-1级台阶，可看作f(n-1)
     * 当第一次跳2级，后面剩下n-2级台阶，可看作f(n-2)
     * ....
     * 当第一次跳n-1级，后面剩下1级台阶，可看作f(n-(n-1))=f(1)
     * 当第一次跳n级，后面剩下0级台阶，可看作f(n-n)=f(0)
     * f(n) = f(n-1)+f(n-2)+....+f(1)+f(0)
     * f(n-1) = f(n-2)+f(n-3)+....+f(1)+f(0)
     * 两者相减
     * f(n) = 2*f(n-1)
     *
     * </p>
     * 时间复杂度：O(n) 空间复杂度：O(1)
     *
     * @param n
     * @return
     */
    public int numWays2(int n) {
        //自顶向下
        /**
         * if (n <= 1) {
         return 1;
         }
         return 2 * numWays2(n - 1);
         */
        //自底向上
        if (n <= 1) {
            return n;
        }
        int a = 1;
        int tmp = 1;
        for (int i = 2; i <= n; i++) {
            tmp = 2 * a;
            a = tmp;
        }
        return tmp;
    }

}
