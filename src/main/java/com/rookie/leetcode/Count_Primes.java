package com.rookie.leetcode;

/**
 * Created by Administrator on 2016/8/26.
 */
public class Count_Primes {
    public static void main(String[] args){
        int n=1500000;
        long t1 = System.nanoTime();
        boolean[] a = new boolean[n];
        for(int i=2; i*i<n; i++) {
            if(!a[i]) {
                for(int j=i; i*j<n; j++) {
                    a[i*j] = true;
                }
            }
        }
        int c=0;

        for(int i=2; i<n; i++) {
            if(a[i] == false) ++c;
        }
        System.out.println(c);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);

        //114155 795532414
    }
}
