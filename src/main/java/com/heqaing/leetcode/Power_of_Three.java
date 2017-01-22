package com.heqaing.leetcode;

/**
 * Created by Administrator on 2016/11/4.
 */
public class Power_of_Three {
    public static void main(String args[]){
        int n = 213214341;
        long t1 = System.nanoTime();
        boolean ret = isPowerOfThree(n);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static boolean isPowerOfThree(int n) {
        if(n<=0){
            return false;
        }
        double res = Math.log(n)/Math.log(3);
        int temp = (int)res;
        return (temp+1-res)< 0.0000000001||(res-temp)<0.0000000001;
    }
}
