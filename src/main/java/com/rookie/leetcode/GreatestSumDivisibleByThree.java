package com.rookie.leetcode;

import java.util.Arrays;

public class GreatestSumDivisibleByThree {
    public static void main(String[] args) {
        GreatestSumDivisibleByThree instance = new GreatestSumDivisibleByThree();
        int[] nums = {3, 6, 5, 1, 8};
        System.out.println(instance.maxSumDivThree(nums));
    }

    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        int mod = sum % 3;
        if (mod == 0) return sum;

        while (mod <= sum) {
            if (coinChange(nums, mod)) {
                return sum - mod;
            }
            mod += 3;
        }
        return 0;
    }

    private boolean coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = amount; i >= coin; i--) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] != amount + 1;
    }
}
