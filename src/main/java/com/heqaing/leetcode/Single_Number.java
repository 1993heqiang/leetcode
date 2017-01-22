package com.heqaing.leetcode;

/**
 * Created by Administrator on 2016/9/7.
 */
public class Single_Number {
    public static void main(String args[]){
        int[] nums = {2,2,3,3,9,5,5,4,7,4,7,10,10,11,13,11,13,99,9};
        long t1 = System.nanoTime();
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            result = result ^ nums[i];
        }
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(result);
    }
}
