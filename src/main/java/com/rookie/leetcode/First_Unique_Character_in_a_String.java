package com.rookie.leetcode;

import java.util.*;

/**
 * Created by Administrator on 2016/9/6.
 */
public class First_Unique_Character_in_a_String {
    public static void main(String args[]){
        String s = "4324";//loveleetcode
        long t1 = System.nanoTime();
        char[] arr = s.toCharArray();
        if(arr.length==0){
            System.out.println(-1);
        }else{
            List<Character> list1 = new ArrayList<Character>();//存放没有重复的元素
            List<Character> list2 = new ArrayList<Character>();//存放重复的元素
            List<Integer> list3 = new ArrayList<Integer>();//存放没有重复的元素的位置
            char cur_char;
            boolean flag1,flag2;
            int pos;
            for(int i=0;i<arr.length;i++){
                cur_char = arr[i];
                flag2 = list2.contains(cur_char);
                if(!flag2){
                    flag1 = list1.contains(cur_char);
                    if(!flag1){
                        list1.add(cur_char);
                        list3.add(i);
                    }else{
                        list2.add(cur_char);
                        pos = list1.indexOf(cur_char);
                        list3.remove(pos);
                        list1.remove(pos);
                    }
                }
            }
            if(list3.size()==0){
                System.out.println(-1);
            }else{
                System.out.println(list3.get(0));
            }
        }
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
    }
}
