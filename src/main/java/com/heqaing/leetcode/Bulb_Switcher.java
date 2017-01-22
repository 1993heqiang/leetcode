package com.heqaing.leetcode;

/**
 * Created by Administrator on 2016/12/1.
 */
public class Bulb_Switcher {
    public static void main(String args[]){
        int n = 1000000;
        long t1 = System.nanoTime();
        int ret = bulbSwitch(n);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int bulbSwitch(int n) {
        return (int) (n >= 0 ? Math.sqrt(n) : 0);
    }
}
