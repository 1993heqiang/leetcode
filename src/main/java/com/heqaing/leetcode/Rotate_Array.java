package com.heqaing.leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/24.
 */
public class Rotate_Array {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3,4,5,6};
        int k = 2;
        int len = nums.length;
        int[] nums1 = new int[len];
        for(int i=0;i<len;i++){
            nums1[(i+k)%len] = nums[i];
        }
        System.arraycopy(nums1,0,nums,0,len);
       System.out.println(Arrays.toString(nums));
    }
}
