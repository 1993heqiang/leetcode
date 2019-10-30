package com.rookie.leetcode;

/**
 * Created by Administrator on 2016/8/27.
 */
public class Longest_Common_Prefix {
    public static void main(String[] args){
        String[] strs = {"qwerjijoigj","qwerg","qwergdfdf","qwerfdsfr"};
        long t1 = System.nanoTime();
        int len = strs.length;
        StringBuilder sb = new StringBuilder();
        if(len==0){
        }else {
            int minLen = strs[0].length();
            int curLen;
            for (int i = 1; i < strs.length; i++) {
                curLen = strs[i].length();
                if (curLen < minLen) minLen = curLen;
            }
            char curChar;
            boolean flag = true;
            for (int i = 0; i < minLen; i++) {
                curChar = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].charAt(i) != curChar) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    break;
                }
                sb.append(curChar);
            }
        }
        long t2 = System.nanoTime();
        System.out.println(sb.toString());
        System.out.println(t2-t1);
    }
}
