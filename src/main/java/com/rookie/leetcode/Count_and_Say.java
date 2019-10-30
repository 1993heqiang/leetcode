package com.rookie.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/9/3.
 */
public class Count_and_Say {
    public static void main(String args[]){
        int n = 3;
        long t1 = System.nanoTime();
        String curStr = "13112221";
   //     String curStr = "1";
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char[] temp;
        char tempChar;
        for(int i=0;i<9;i++){
            temp = curStr.toCharArray();
            tempChar = temp[0];
            for(int j=1;j<temp.length;j++){
                if(temp[j]!=tempChar){
                    sb.append(""+count+tempChar);
                    tempChar = temp[j];
                    count = 0;
                }
                count++;
            }
            sb.append(""+count+tempChar);
            curStr = sb.toString();
            count = 1;
            sb.delete(0,sb.length());
        }
        long t3 = System.nanoTime();
        System.out.println(t3-t1);
        System.out.println(curStr);
    }
}
