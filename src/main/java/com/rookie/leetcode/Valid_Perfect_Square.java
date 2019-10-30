package com.rookie.leetcode;

/**
 * Created by Administrator on 2017/4/15 0015.
 */
public class Valid_Perfect_Square {
    public static void main(String args[]){
        int num = 987979;
        long t1 = System.nanoTime();
        boolean ret = isPerfectSquare(num);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
