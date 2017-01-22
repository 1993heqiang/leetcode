package com.heqaing.leetcode;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public class HammingDistance {
    public static void main(String args[]){
        int x = 1,y = 343215243;
        long t1 = System.nanoTime();
        int ret = hammingDistance(x,y);
        long t2 = System.nanoTime();
        System.out.println(ret+"---"+(t2-t1));
    }
    public static int hammingDistance(int x, int y) {
        int mask = x^y;
        int mag = Integer.SIZE - Integer.numberOfLeadingZeros(mask);
        int ret = 0;
        do {
            if((mask&1)==1) ret++;
            mask = mask>>1;
            mag--;

        } while (mag>0);
        return ret;
    }
}
