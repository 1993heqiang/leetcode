package com.rookie.leetcode;

import java.util.Arrays;

public class SubarraySumsDivisibleByK {
    public static void main(String[] args) {
        SubarraySumsDivisibleByK instance = new SubarraySumsDivisibleByK();
        int[] A = {4, 5, 0, -2, -3, 1};
        int K = 5;
        int result = instance.subarraysDivByK(A, K);
        System.out.println(result);
    }

    public int subarraysDivByK(int[] A, int K) {
        int len = A.length;
        int[] temp = new int[len + 1];
        temp[0] = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += A[i];
            temp[i + 1] = sum;
        }
        System.out.println(Arrays.toString(temp));
        // 4 9 9 7 4 2
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (Math.abs(temp[j] - temp[i]) % K == 0) {
                    count++;
                }
            }
        }
        return count;
    }

}
