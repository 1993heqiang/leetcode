package com.rookie.leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/16.
 */
public class Two_Sum_II {
    public static void main(String args[]){
        int[] numbers = {0,1,23};
        int target = 1;
        long t1 = System.nanoTime();
        int[] ret = twoSum(numbers,target);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(Arrays.toString(ret));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        if(len==2){
            return new int[]{1,2};
        }
        int[] ret = new int[2];
        int temp = target/2;
        for(int i=0;i<len;i++){
            if(numbers[i]>temp){
                ret[0] = i-1;
                break;
            }
        }
        ret[1] = ret[0]+1;
        for (int i=len-1;i>ret[0];i--){
            if(numbers[i]<=target){
                ret[1] = i;
                break;
            }
        }
        int loc = ret[0]+1;
        for (int i=ret[0];i>=0;i--){
            for(int j=loc;j<=ret[1];j++){
                temp = numbers[i]+numbers[j];
                if(temp==target){
                    ret[0] = i+1;
                    ret[1] = j+1;
                    return ret;
                }else if(temp>target){
                    loc = j;
                    break;
                }
            }
        }
        return ret;
    }
}
