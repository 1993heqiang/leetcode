package com.heqaing.leetcode;

/**
 * Created by Administrator on 2016/11/3.
 */
public class Arranging_Coins {
    public static void main(String args[]){
        int n = 0;
        long t1 = System.nanoTime();
        int ret = arrangeCoins(n);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int arrangeCoins(int n) {
        int temp = 1;
        while(n>=temp){
            n -= temp;
            temp++;
        }
        return temp-1;
    }
}
