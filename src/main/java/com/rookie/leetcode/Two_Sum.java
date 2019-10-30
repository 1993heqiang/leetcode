package com.rookie.leetcode;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * Created by Administrator on 2016/8/26.
 */
public class Two_Sum {
    public static void main(String[] args){
        int[] nums = {-3, 4, 3, 90};
        int target = 0;
        int[] ret = new int[2];
        int len = nums.length;
        int temp;
        boolean flag = false;
        for(int i=0;i<len;i++){
            temp = target-nums[i];
            for(int j=i+1;j<len;j++){
                if(nums[j]==temp){
                    ret[0] = i;
                    ret[1] = j;
                    flag = true;
                    break;
                }
            }

            if(flag) break;
        }
        System.out.println(Arrays.toString(ret));
    }
}
