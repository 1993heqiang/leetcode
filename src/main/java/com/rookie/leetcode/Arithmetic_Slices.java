package com.rookie.leetcode;

/**
 * Created by Administrator on 2016/11/11.
 */
public class Arithmetic_Slices {
    public static void main(String args[]){
        int[] A = {1,2,3,4,5,6,7,8};
        long t1 = System.nanoTime();
        int ret = numberOfArithmeticSlices(A);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);

    }
    public static int numberOfArithmeticSlices(int[] A) {
        int ALen = A.length;
        int ret = 0;
        if(ALen<3){
            return ret;
        }
        int count = 1;
        int diff = A[1]-A[0];
        int temp;
        for(int i=1;i<ALen-1;i++){
            temp = A[i+1]-A[i];
            if(temp==diff){
               count++;
            }else{
                if (count >= 2) {
                    ret += number(count);
                }
                count = 1;
                diff = temp;
            }
        }
        if(count>=2){
            ret += number(count);
        }
        return ret;
    }
    public static int number(int count){
        int sum = 0;
        for(int i=2;i<=count;i++){
            sum += count-i+1;
        }
        return sum;
    }
}
