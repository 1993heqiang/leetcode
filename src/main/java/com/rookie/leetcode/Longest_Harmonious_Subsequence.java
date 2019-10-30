package com.rookie.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HeQiang on 2017-06-06 18:21.
 */

public class Longest_Harmonious_Subsequence {
    public static void main(String[] args){
        int[] nums = {1,3,2,2,5,2,3,7};
        System.out.println(findLHS(nums));
    }
    public static int findLHS(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int temp;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int maxLen = 0;
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(map.containsKey(e.getKey()+1)){
                temp = e.getValue()+map.get(e.getKey()+1);
                maxLen = temp>maxLen?temp:maxLen;
            }
        }
        return maxLen;
    }
}
