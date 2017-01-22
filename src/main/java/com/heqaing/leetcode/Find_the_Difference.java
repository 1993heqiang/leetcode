package com.heqaing.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/6.
 */
public class Find_the_Difference {
    public static void main(String[] args){
        String s = "abcd";
        String t = "abccd";
        long t1 = System.nanoTime();
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        List<Character> list = new ArrayList<Character>();
        for(int i=0;i<arr2.length;i++){
            list.add(i,arr2[i]);
        }
        for(int i=0;i<arr1.length;i++){
            if(list.contains(arr1[i])){
                list.remove(list.indexOf(arr1[i]));
            }
        }
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(list.get(0));
    }
}
