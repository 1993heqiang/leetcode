package com.heqaing.leetcode;

/**
 * Created by Administrator on 2017/4/15 0015.
 */
public class Search_Insert_Position {
    public static void main(String args[]){
        int[] nums = {1};
        int target = 2;
        long t1 = System.nanoTime();
        int ret = searchInsert(nums,target);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int begin = 0;
        int end = len-1;
        int temp ;
        int index ;
        while (begin<=end){
            index = (begin+end)/2;
            temp = nums[index];
            if(target<temp){
                end = index-1;
            }else if(target>temp) {
                begin = index+1;
            }else {
                return index;
            }
        }
        return begin;
    }
}
