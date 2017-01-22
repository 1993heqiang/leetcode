package com.heqaing.leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/26.
 */
public class ZigZag_Conversion {
    public static void main(String[] args){
        String s = "PAYPALISHIRING";
        int numRows = 3;
        long t1 = System.nanoTime();
        int len= s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=i;j<len;j=j+2*(numRows-1)){
                sb.append(s.charAt(j));
                if(!(i==0||i==numRows-1)&&(j+2*(numRows-1-i)<s.length())){
                    sb.append(s.charAt(j+2*(numRows-1-i)));
                }
            }
        }
        long t2 = System.nanoTime();
        System.out.println(sb.toString());
        System.out.println(t2-t1);

    }
}