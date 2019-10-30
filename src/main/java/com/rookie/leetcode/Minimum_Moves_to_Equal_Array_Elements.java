package com.rookie.leetcode;

/**
 * Created by Administrator on 2017/1/11.
 */
public class Minimum_Moves_to_Equal_Array_Elements {
    public static void main(String args[]){
        int[] num = {1,2147483647};
        long t1 = System.nanoTime();
        int ret = minMoves(num);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int minMoves(int[] nums) {
        int len = nums.length;
        int min = nums[0];
        long ret = nums[0];
        for(int i=1;i<len;i++){
            if(nums[i]<min) min = nums[i];
            ret += nums[i];
        }
        return (int)(ret-len*min);
    }
}
