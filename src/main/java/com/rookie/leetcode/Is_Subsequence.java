package com.rookie.leetcode;

/**
 * Created by Administrator on 2016/11/23.
 */
public class Is_Subsequence {
    public static void main(String args[]){
        String s = "abc";
        String t = "ahbgdureowhfrejfoiwejfoewfewjofiewfewhgrehfoiewjfoiewhfewoiwufoihegfuewoic";
        long t1 = System.nanoTime();
        boolean ret = isSubsequence(s,t);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen==0) return true;
        if(tLen<sLen) return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int point = 0;
        for(int i=0;i<tLen;i++){
            if(sArr[point]==tArr[i]){
                if((++point^sLen)==0) return true;
            }
        }
        return false;
    }
}
