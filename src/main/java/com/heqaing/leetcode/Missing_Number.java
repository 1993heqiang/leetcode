package com.heqaing.leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/23.
 */
public class Missing_Number {
    public static void main(String args[]){
        int[] nums = {0,1,2,4,5,6};
        long t1 = System.nanoTime();
        int ret = missingNumber(nums);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for(int i=0;i<len;i++){
            sum += nums[i];
        }
        int expect = len*(len-1)/2;
        if(sum==expect){
            return len;
        }else {
            return len-(sum-expect);
        }
    }
}
