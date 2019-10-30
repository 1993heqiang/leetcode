package com.rookie.leetcode;

/**
 * Created by Administrator on 2017/4/15 0015.
 */
public class Perfect_Number {
    public static void main(String args[]){
        int num = 496;
        long t1 = System.nanoTime();
        boolean ret = checkPerfectNumber(33550336);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static boolean checkPerfectNumber(int num) {
        if(num<4) return false;
        int i = 2;
        int sum = 1;
        while (true){
            if(num%i!=0) break;
            sum += i;
            sum += num/i;
            i *=2;
        }
        return num==sum?true:false;
    }
}
