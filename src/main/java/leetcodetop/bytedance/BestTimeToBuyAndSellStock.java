package leetcodetop.bytedance;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int maxProfit = 0;
        int curMin = prices[0];
        int temp;
        for (int i = 1; i < prices.length; i++) {
            temp = prices[i] - curMin;
            if (temp > 0) {
                maxProfit = Math.max(maxProfit, temp);
            } else {
                curMin = prices[i];
            }
        }
        return maxProfit;
    }
}
