package com.heqaing.leetcode;

/**
 * Created by Administrator on 2017/1/11.
 */
public class Number_Complement {
    public static void main(String args[]){
        int num = 1232132132;
        long t1 = System.nanoTime();
        int ret = findComplement(num);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int findComplement(int num) {
        int original = num;
        int mask = 1;
        while (original>0){
            original = original>>1;
            mask = mask<<1;
        }
        return (mask-1)^num;
    }
}
