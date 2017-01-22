package com.heqaing.leetcode;

/**
 * Created by Administrator on 2016/11/4.
 */
public class Nth_Digit {
    public static void main(String args[]){
        int n =1000000000;
        long t1 = System.nanoTime();
        int ret = findNthDigit(n);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int findNthDigit(int n) {
        if(n<10){
            return n;
        }
        int t = 1,count = 0;
        int temp ;
        int mult = 1;
        while(true){
            temp = 9*mult;
            if(n<temp*t||t>8) break;
            n -= t*temp;
            count += temp;
            mult *= 10;
            t++;
        }
        count += n/t;
        int index = n%t;
        if(index==0){
            return count%10;
        }else {
            int div = 1;
            for(int i=0;i<t-index;i++) div*=10;
            return  ((count+1)/div)%10;
        }
    }
}
