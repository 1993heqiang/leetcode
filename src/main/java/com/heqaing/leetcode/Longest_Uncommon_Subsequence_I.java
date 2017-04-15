package com.heqaing.leetcode;

/**
 * Created by Administrator on 2017/4/15 0015.
 */
public class Longest_Uncommon_Subsequence_I {
    public static void main(String args[]){
        String a = "aba";
        String b = "cdc";
        long t1 = System.nanoTime();
        int ret = findLUSlength(a,b);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int findLUSlength(String a, String b) {
        if(a.equals(b)){
            return -1;
        }else {
            int aLen = a.length();
            int bLen = b.length();
            return aLen>bLen?aLen:bLen;
        }
    }
}
