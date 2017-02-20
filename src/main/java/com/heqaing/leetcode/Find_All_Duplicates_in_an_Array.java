package com.heqaing.leetcode;

import java.util.*;

/**
 * Created by HeQiang on 2017/1/24.
 */
public class Find_All_Duplicates_in_an_Array {
    public static void main(String args[]){
        int[] num = {4,3,2,7,8,2,3,1};
        long t1 = System.nanoTime();
        List<Integer> ret = findDuplicates(num);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(Arrays.toString(ret.toArray()));
    }
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(e.getValue()==2) ret.add(e.getKey());
        }
        return ret;
    }
}
