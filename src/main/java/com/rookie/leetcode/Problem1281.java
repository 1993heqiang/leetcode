package com.rookie.leetcode;

public class Problem1281 {
    public static void main(String[] args) {
        Problem1281 solution = new Problem1281();
        int n = 234;
        int result = solution.subtractProductAndSum(n);
        System.out.println(result);
    }

    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            product *= digit;
            sum += digit;
        }
        return product - sum;
    }
}
