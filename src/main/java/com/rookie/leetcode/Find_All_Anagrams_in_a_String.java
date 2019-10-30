package com.rookie.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/11/3.
 */
public class Find_All_Anagrams_in_a_String {
    public static void main(String args[]){
        String s = "cbaebabacd";
        String p = "abc";
        long t1 = System.nanoTime();
        List<Integer> ret = findAnagrams(s,p);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        for(Integer i:ret){
            System.out.println(i.intValue());
        }
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        int sLen = s.length();
        int pLen = p.length();
        if(sLen==0||sLen<pLen){
            return list;
        }
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        int[] target = new int[26];
        for(int i=0;i<pLen;i++){
            target[pArr[i]-'a'] ++;
        }
        int[] temp = new int[26];
        int count = 0;
        while (true){
            if(count<pLen){
                temp[sArr[count]-'a']++;
            }else {
                if(compare(target,temp)){
                    list.add(count-pLen);
                }
                if(count==sLen){
                    break;
                }
                temp[sArr[count-pLen]-'a']--;
                temp[sArr[count]-'a']++;
            }
            count++;
        }
        return list;
    }
    public static boolean compare(int[] target,int[] temp){
        for(int i=0;i<target.length;i++){
            if(target[i]!=temp[i]) return false;
        }
        return true;
    }
}
