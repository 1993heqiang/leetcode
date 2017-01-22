package com.heqaing.leetcode;

/**
 * Created by Administrator on 2016/11/22.
 */
public class Count_Numbers_with_Unique_Digits {
    public static void main(String args[]){
        int n=0;
        long t1 = System.nanoTime();
        int ret = countNumbersWithUniqueDigits(n);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        int count = 10;
        int temp;
        for(int i=2;i<=n;i++){
            temp = 9;
            for(int j=1;j<i;j++){
                temp *= 9-j+1;
            }
            count+=temp;
        }
        return count;
    }
}
