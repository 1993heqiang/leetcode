package com.heqaing.leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/9/3.
 */
public class Merge_Sorted_Array {
    public static void main(String args[]){
        int[] nums1 = new int[10];
        int m = 4;
        int[] nums2 = new int[7];
        int n = 3;
        nums1[0] = 15;
        nums1[1] = 98;
        nums1[2] = 101;
        nums1[3] = 198;

        nums2[0] = 37;
        nums2[1] = 89;
        nums2[2] = 500;

        long t1 = System.nanoTime();
        int[] ret = new int[m+n];
        int i = 0;
        int j = 0;
        int k = 0;
        while(true){
            if(i==m||j==n){
                break;
            }
            if(nums1[i]>=nums2[j]){
               ret[k] = nums2[j];
                j++;
            }else{
                ret[k] = nums1[i];
                i++;
            }
            k++;
        }
        if(i==m){
            for(int a=j;a<n;a++){
                ret[k] = nums2[a];
                k++;
            }
        }else if(j==n){
            for(int a=i;a<m;a++){
                ret[k] = nums1[a];
                k++;
            }
        }
        for(int a=0;a<ret.length;a++){
            nums1[a] = ret[a];
        }
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(Arrays.toString(nums1));


    }
}
