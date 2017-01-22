package com.heqaing.leetcode;

import java.util.*;

/**
 * Created by Administrator on 2016/8/28.
 */
public class Contains_Duplicate_II {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,8,7,8};
        int k=3;
        boolean ret = false;
        Set<Integer> appearedNum = new HashSet<Integer>();
        int start = 0, end = 0;
        for(int i = 0; i < nums.length; i++){
            if(!appearedNum.contains(nums[i])){
                appearedNum.add(nums[i]);
                end++;
            } else ret = true;
            if(end - start  > k) {
                appearedNum.remove(nums[start]);
                start++;
            }
        }
        System.out.println(appearedNum.size());
        System.out.println(ret);
    }
}
