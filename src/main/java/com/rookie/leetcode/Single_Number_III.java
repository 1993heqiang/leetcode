package com.rookie.leetcode;

import java.util.*;

/**
 * Created by Administrator on 2016/11/13.
 */
public class Single_Number_III {
    public static void main(String args[]){
        int[] nums = {1, 2, 1, 3, 2, 5};
        long t1 = System.nanoTime();
        int[] ret = singleNumber(nums);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(Arrays.toString(ret));
    }
    public static int[] singleNumber(int[] nums) {
        int t=0;
        for(int i=0;i<nums.length;i++){
            t ^= nums[i];
        }
        int mask = t & ~(t-1);
        int x=0;
        int y=0;
        for(int j=0;j<nums.length;j++){
            if((nums[j]& mask)==(0&0)){
                x^=nums[j];
            }else {
                y^=nums[j];
            }
        }
        return new int[]{x,y};
    }
}
