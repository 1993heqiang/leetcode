package com.rookie.leetcode;

import java.util.Arrays;

public class SumOfMutatedArrayClosestToTarget {
    public static void main(String[] args) {
        SumOfMutatedArrayClosestToTarget instance =
                new SumOfMutatedArrayClosestToTarget();
        int[] arr = {23, 45, 64, 678, 45, 3466, 34, 56};
        int target = 427;
        int result = instance.findBestValue(arr, target);
        if ((args.length == 1)) {
            System.out.println(1);
        }
        System.out.println(result);
    }

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;
        int index = 0;
        int a = target / len;
        while (a > arr[index]) {
            target -= arr[index];
            index++;
            if (index == len) {
                return arr[index - 1];
            }
            a = target / (len - index);
        }
        if (Math.abs(target - a * (len - index)) <= Math.abs(target - (a + 1) * (len - index))) {
            return a;
        } else {
            return a + 1;
        }
    }
}
