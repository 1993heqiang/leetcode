package com.rookie.leetcode;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/9/5.
 */
public class Isomorphic_Strings {
    public static void main(String args[]){
        String s = "paper";
        String t = "title";
        long t1 = System.nanoTime();
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        boolean flag = true;
        if(arr1.length==0){
            System.out.println(true);
        }else{
            HashMap<Character,Character> map = new HashMap<Character, Character>();
            for(int i=0;i<arr1.length;i++){
                if(!map.containsKey(arr1[i])){
                    map.put(arr1[i],arr2[i]);
                }else{
                    if(map.get(arr1[i])!=arr2[i]){
                        flag = false;
                        break;
                    }
                }
            }
            map.clear();
            for(int i=0;i<arr2.length;i++){
                if(!map.containsKey(arr2[i])){
                    map.put(arr2[i],arr1[i]);
                }else{
                    if(map.get(arr2[i])!=arr1[i]){
                        flag = false;
                        break;
                    }
                }
            }
        }
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(flag);

    }
}
