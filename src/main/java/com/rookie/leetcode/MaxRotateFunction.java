package com.rookie.leetcode;

/**
 * Created by Administrator on 2016/10/20.
 */
public class MaxRotateFunction {
    public static void main(String args[]){
        long t1 = System.nanoTime();
        int[] A = {4,3,2,6,3,4,5,3,1,32,4,5,3,1,2,3,4,5,3,2,1,2,3,4,5};
        int len = A.length;
        int f0 = 0;
        int sumA = 0;
        for(int i=0;i<len;i++){
            f0+=i*A[i];
            sumA += A[i];
        }
        int max = f0;
        int temp = 0;
        for(int i=1;i<len;i++){
            temp = f0-len*A[len-i%len]+sumA;
            if(temp>max) max = temp;
            f0 = temp;
        }
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(max);
    }
}

