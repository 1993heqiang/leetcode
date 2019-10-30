package com.rookie.leetcode;

/**
 * Created by Administrator on 2016/11/22.
 */
public class Best_Time_to_Buy_and_Sell_Stock {
    public static void main(String args[]){
        int[] prices = {7, 1, 5, 3, 6, 4};
        long t1 = System.nanoTime();
        int ret = maxProfit(prices);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int maxProfit = 0;
        int curMin = prices[0];
        int temp;
        for (int i = 1; i < prices.length; i++) {
            temp = prices[i]-curMin;
            if(temp>0){
                maxProfit = maxProfit>temp?maxProfit:temp;
            }else {
                curMin = prices[i];
            }
        }
        return maxProfit;
    }
}
