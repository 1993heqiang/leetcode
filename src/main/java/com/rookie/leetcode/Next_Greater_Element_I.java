package com.rookie.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Next_Greater_Element_I {

	public static void main(String[] args) {
		int[] findNums = {4,1,2};
		int[] nums = {1,3,4,2};
		long t1 = System.nanoTime();
		int[] ret = nextGreaterElement(findNums, nums);
		long t2 = System.nanoTime();
		System.out.println(t2-t1);
		System.out.println(Arrays.toString(ret));
	}
	public static int[] nextGreaterElement(int[] findNums, int[] nums) {
		int findNumsLen = findNums.length;
		int numsLen = nums.length;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<numsLen;i++){
			map.put(nums[i], i);
		}
		int[] ret = new int[findNumsLen];
		int curNum;
		outer:
		for(int i=0;i<findNumsLen;i++){
			curNum = findNums[i];
			for(int j=map.get(curNum)+1;j<numsLen;j++){
				if(nums[j]>curNum){
					ret[i] = nums[j];
					continue outer;
				}
			}
			ret[i] = -1;
		}
        return ret;
    }
}
