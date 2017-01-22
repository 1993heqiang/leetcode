package com.heqaing.leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/16.
 */
public class Product_of_Array_Except_Self {
    public static void main(String args[]){
        int[] nums = {2,3,4,5};
        long t1 = System.nanoTime();
        int[] ret = productExceptSelf(nums);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(Arrays.toString(ret));
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
