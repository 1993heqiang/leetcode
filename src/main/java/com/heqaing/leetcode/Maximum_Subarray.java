package com.heqaing.leetcode;

/**
 * Created by Administrator on 2017/4/15 0015.
 */
public class Maximum_Subarray {
    public static void main(String args[]){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        long t1 = System.nanoTime();
        int ret = maxSubArray(nums);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(sum>0){
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            if(sum>max){
                max = sum;
            }
        }
        return max;
    }
}
