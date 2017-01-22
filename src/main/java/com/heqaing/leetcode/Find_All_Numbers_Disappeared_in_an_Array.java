package com.heqaing.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/1.
 */
public class Find_All_Numbers_Disappeared_in_an_Array {
    public static void main(String args[]){
        int[] nums = {4,3,2,7,8,2,3,1};
        long t1 = System.nanoTime();
        List<Integer> list = findDisappearedNumbers(nums);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        for (Integer i:list){
            System.out.println(i.intValue());
        }
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int max = nums.length;
        for(int i=0;i<max;i++){
            if(nums[i]>max){
                nums[nums[i]%max-1] +=max;
            }else {
                nums[nums[i]-1] +=max;
            }
        }
        for(int i=0;i<max;i++){
            if(nums[i]<=max){
                list.add(i+1);
            }
        }
        return list;
    }
}
