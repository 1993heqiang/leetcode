package com.rookie.leetcode;

import java.util.Arrays;

/**
 * Created by HeQiang on 2017-06-02 15:52.
 */
public class Array_Partition_I {
    public static void main(String[] args){
        int[] nums = {1,4,3,2};
        long t1 = System.nanoTime();
        int result = arrayPairSum(nums);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(result);
    }
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for(int i=0;i<nums.length;i+=2){
            result += nums[i];
        }
        return result;
    }
}
