package com.itsnine.code.sword.middle.dp;

/**
 * 股票的最大利润
 * 按时间顺序输入每天的股票价格，仅买卖一次可获得的最大利润
 *
 * @author xu.sun
 * @create 2021-08-26-10:44 下午
 */
public class MaxProfit {
    /**
     * 暴力破解
     * 遍历当前时间股票价格相比之后每天的价格取最大值
     * 第一次外层遍历：第一天
     * 第一次内层遍历：第一天再与第二天相比，计算最大利润...
     * 第二次内层遍历：第一天再与第三天相比，对比之前计算的利润取最大值...
     * .....
     * 第二次外层遍历：第二天与第三天的相比，对比之前计算的利润取最大值
     * .....
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     *
     * @param price
     * @return
     */
    public int resolve(int[] price) {
        int max = 0;
        for (int i = 0; i < price.length; i++) {
            for (int j = i + 1; j < price.length; j++) {
                int tmp = price[j] - price[i];
                if (tmp > max) max = tmp;
            }
        }
        return max;
    }

    /**
     * 动态规划
     * 记录历史的价格最低值
     * 再将利润与当前价格-历史最低价格取小，获取当前最大利润
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param prices
     * @return
     */
    public int dynamic(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
