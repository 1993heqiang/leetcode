package com.heqaing.leetcode;

import java.util.List;

/**
 * Created by heqiang on 2017/1/22.
 */
public class IncreasingSubsequences {
    public static void main(String args){
        int[] nums = {4, 6, 7, 7};
        long t1 = System.nanoTime();
        List<List<Integer>> ret = findSubsequences(nums);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret.toString());
    }
    public static List<List<Integer>> findSubsequences(int[] nums) {
        int len = nums.length;
        if(len<=2){};
        return null;
    }
}
