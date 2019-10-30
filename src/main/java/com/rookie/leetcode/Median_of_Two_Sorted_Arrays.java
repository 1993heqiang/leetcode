package com.rookie.leetcode;

import java.util.Arrays;

/**
 * @author heqiang
 * @date 18-7-27 上午10:12
 * @description
 * @modified by
 */
public class Median_of_Two_Sorted_Arrays {
    public static void main(String[] args){
        int[] nums1 = {1,2};
        int[] num2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1,num2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int maxIndex = (len1+len2)/2;
        int[] temp = new int[maxIndex+1];
        int pos1 = 0;
        int pos2 = 0;
        int index = 0;
        while (index<=maxIndex){
            if(pos1<len1&&pos2<len2){
                if(nums1[pos1]<=nums2[pos2]){
                    temp[index++] = nums1[pos1++];
                }else {
                    temp[index++] = nums2[pos2++];
                }
            }else {
                if (pos1<len1){
                    temp[index++] = nums1[pos1++];
                }else if (pos2<len2){
                    temp[index++] = nums2[pos2++];
                }
            }
        }
        return ((len1+len2)&1)==0?(temp[maxIndex]+temp[maxIndex-1])/2.0:temp[maxIndex];
    }
}

