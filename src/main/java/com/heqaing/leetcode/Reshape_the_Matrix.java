package com.heqaing.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by HeQiang on 2017-06-02 16:18.
 */
public class Reshape_the_Matrix {
    public static void main(String[] args){
        int[][] nums = {{1,2},{3,4}};
        int r = 1,c = 4;
        long t1 = System.nanoTime();
        int[][] result = matrixReshape(nums,r,c);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(Arrays.deepToString(result));
    }
    public static int[][] matrixReshape(int[][] nums, int r, int c){
        int originalSize = 0;
        for(int i=0;i<nums.length;i++){
            originalSize += nums[i].length;
        }
        int newSize = r * c;
        if(originalSize==0||originalSize!=newSize) return nums;
        Queue<Integer> list = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            for (int j=0;j<nums[i].length;j++) list.offer(nums[i][j]);
        }
        int[][] result = new int[r][c];
        for(int i=0;i<r;i++){
            for (int j=0;j<c;j++) result[i][j] = list.poll();
        }
        return result;
    }
}
