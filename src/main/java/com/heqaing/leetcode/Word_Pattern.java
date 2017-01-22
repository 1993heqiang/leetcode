package com.heqaing.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/9/3.
 */
public class Word_Pattern {
    public static void main(String[] args){
        String pattern = "abba";
        String str = "dog dog dog dog";
        String[] arr = str.split(" ");
        HashMap<Character,String> map = new HashMap<Character, String>();
        char[] arr1 = pattern.toCharArray();
        if(arr.length!=arr1.length){
            System.out.println(false);
        }else{
            boolean flag = true;
            boolean flag1,flag2;
            for(int i=0;i<arr1.length;i++){
                flag1 = map.containsKey(arr1[i]);
                flag2 = map.containsValue(arr[i]);
                if(!flag1&&!flag2){
                    map.put(arr1[i],arr[i]);
                }else{
                    if((flag1&&!flag2)||(flag2&&!flag1)){
                        flag = false;
                        break;
                    }
                }
            }
            System.out.println(flag);
        }
    }
}
