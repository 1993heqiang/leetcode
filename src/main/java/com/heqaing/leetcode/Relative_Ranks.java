package com.heqaing.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Relative_Ranks {

	public static void main(String[] args) {
		int[] nums = {1};
		long t1 = System.nanoTime();
		String[] ret = findRelativeRanks(nums);
		long t2 = System.nanoTime();
		System.out.println(t2-t1);
		System.out.println(Arrays.toString(ret));
	}
	public static String[] findRelativeRanks(int[] nums) {
		int len = nums.length;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<len;i++){
			map.put(nums[i], i);
		}
		Arrays.sort(nums);
		String[] ret = new String[len];
		if(len>0){
			ret[map.get(nums[len-1])] = "Gold Medal";
		}
		if(len>1){
			ret[map.get(nums[len-2])] = "Silver Medal";
		}
		if(len>2){
			ret[map.get(nums[len-3])] = "Bronze Medal";
		}
		for(int i=len-4;i>=0;i--){
			ret[map.get(nums[i])] = String.valueOf(len-i);
		}
        return ret;
    }
}
