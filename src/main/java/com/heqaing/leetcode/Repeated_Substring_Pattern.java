package com.heqaing.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/12.
 */
public class Repeated_Substring_Pattern {
    public static void main(String args[]){
        String str = "ab";
        long t1 = System.nanoTime();
        boolean ret = repeatedSubstringPattern(str);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static boolean repeatedSubstringPattern(String str) {
        char[] arr = str.toCharArray();
        int len = arr.length;
        if(len==1) return false;
        List<Integer> positions = new ArrayList<>();
        int position = 0;
        int firstChar = arr[0];
        for(int i=1;i<len;i++){
            if(firstChar!=arr[i]){
                position = i;
                break;
            }
        }
        if(position==0) return true;
        while(position<=len/2){
            position = str.indexOf(firstChar,position+1);
            if(position==-1) break;
            if(len%(position)==0) positions.add(position);
        }
        if(positions.size()==0) return false;
        String mask;
        int maskLen;
        outer:
        for(int i=0;i<positions.size();i++){
            maskLen = positions.get(i);
            mask = str.substring(0,maskLen);
            for(int j=1;j<len/maskLen;j++){
                if(!str.substring(maskLen*j,maskLen*j+maskLen).equals(mask)) continue outer;
            }
            return true;
        }
        return false;
    }
}
