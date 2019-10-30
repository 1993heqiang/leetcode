package com.rookie.leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/1/18.
 */
public class MinimumMovestoEqualArrayElementsII {
    public static void main(String args[]){
        int[] nums = {1,2,3};
        long t1 = System.nanoTime();
        int ret = minMoves2(nums);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        long preSum = 0,offSum = 0;
        for(int i=0;i<len/2;i++){
            preSum += nums[i];
        }
        if(len%2!=0){
            for(int i=len/2+1;i<len;i++){
                offSum += nums[i];
            }
        }else {
            for(int i=len/2;i<len;i++) {
                offSum += nums[i];
            }
        }
        return (int)(offSum-preSum);
    }
}
