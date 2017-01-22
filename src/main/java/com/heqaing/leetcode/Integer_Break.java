package com.heqaing.leetcode;

/**
 * Created by Administrator on 2016/11/22.
 */
public class Integer_Break {
    public static void main(String args[]){
        int n = 50;
        long t1 = System.nanoTime();
        int ret = integerBreak(n);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int integerBreak(int n) {
        int max = 1;
        int temp;
        int mul,over;
        for(int i=2;i<=(n+1)/2;i++){
            mul = n/i;
            while (true){
                temp = 1;
                over = n-(i-1)*mul;
                if(over<=0){
                    break;
                }
                for(int j=1;j<i;j++){
                    temp *= mul;
                }
                temp *= over;
                max = max>temp?max:temp;
                mul++;
            }
        }
        return max;
    }
}
