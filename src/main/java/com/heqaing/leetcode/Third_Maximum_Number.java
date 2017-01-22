package com.heqaing.leetcode;


import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/26.
 */
public class Third_Maximum_Number {
    public static void main(String[] args){
        int[] nums = {6,6,6,6,6,6,6,6,1};
        long t1 = System.nanoTime();
        int i = thirdMax(nums);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(i);

    }
    public static int thirdMax(int[] nums){
        int len = nums.length;
        if(len==1){
            return nums[0];
        }else if(len==2){
            return nums[0]>nums[1]?nums[0]:nums[1];
        }else{
            int first = nums[0];
            for(int i=1;i<len;i++){
                if(nums[i]>first) first = nums[i];
            }
            int second = first;
            for(int i=0;i<len;i++){
                if(nums[i]<first){
                    if(second==first){
                        second = nums[i];
                    }else if(nums[i]>second){
                        second = nums[i];
                    }
                }
            }
            if(second==first) return first;
            int third = second;
            for(int i=0;i<len;i++) {
                if(nums[i]<second){
                    if (third == second) {
                        third = nums[i];
                    } else if (nums[i] > third) {
                        third = nums[i];
                    }
                }
            }
            return third==second?first:third;
        }
    }

}
