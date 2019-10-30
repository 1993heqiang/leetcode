package com.rookie.leetcode;

import java.util.Arrays;

/**
 * 165.Compare two version numbers version1 and version2.
 */
public class Compare_Version_Numbers {
    public static void main(String[] args){
        String version1 = "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000";
        String version2 = "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.100000";
        long t1 = System.nanoTime();
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        long t2 = System.nanoTime();
        int l = str1.length>str2.length?str1.length:str2.length;
        int temp1 = 0;
        int temp2 = 0;
        for(int i=0; i<l; i++){
            if(i<str1.length)
                temp1 = Integer.parseInt(str1[i]);
            if(i<str2.length)
                temp2 = Integer.parseInt(str2[i]);
            if(temp1!=temp2){
                int k = temp1>temp2?1:-1;
                System.out.println(k);
                break;
            }
            temp1 = 0;
            temp2 = 0;
        }
        long t3 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(t3-t2);
        System.out.println("0");

    }
}