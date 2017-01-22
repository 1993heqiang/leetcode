package com.heqaing.leetcode;

/**
 * Created by Administrator on 2016/11/22.
 */
public class Best_Time_to_Buy_and_Sell_Stock_II {
    public static void main(String args[]){
        int[] prices = {7, 1, 5, 3, 6, 4,3,5,2,3,5,6,43,656,2,6,6432,2,6,6,234,6,623,2346,62};
        long t1 = System.nanoTime();
        int ret = maxProfit(prices);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int curProfit = 0;
        int curPosition = 0;
        for (int i = 1; i < len; i++) {
            if(prices[i-1]>prices[i]){
                curProfit += prices[i-1]-prices[curPosition];
                curPosition = i;
            }
        }
        if(curPosition<len-1){
            curProfit += prices[len-1]-prices[curPosition];
        }
        return curProfit;
    }
}
