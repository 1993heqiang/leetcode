package com.rookie.leetcode;

/**
 * Created by Administrator on 2017/1/18.
 */
public class Max_Consecutive_Ones {
    public static void main(String args[]){
        int[] nums = {1,1,0,1,1,1};
        long t1 = System.nanoTime();
        int ret = findMaxConsecutiveOnes(nums);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0,position = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                max = i-position>max?i-position:max;
                position = i+1;
            }
        }
        return nums.length-position>max?nums.length-position:max;
    }
}
