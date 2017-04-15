package com.heqaing.leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/4/15 0015.
 */
public class Reverse_Words_in_a_String_III {
    public static void main(String args[]){
        String input = "Let's take LeetCode contest";
        long t1 = System.nanoTime();
        String output = reverseWords(input);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(output);
        //"s'teL ekat edoCteeL tsetnoc"
    }
    public static String reverseWords(String s) {
        int len = s.length();
        String[] words = s.split(" ");
        char[] ret = new char[len];
        int index = 0;
        for(int i=0;i<words.length;i++){
            char[] wordArr = words[i].toCharArray();
            swap(wordArr,0,wordArr.length-1);
            System.arraycopy(wordArr,0,ret,index,wordArr.length);
            index += wordArr.length;
            if(index<len) ret[index++] = ' ';
        }
        return String.valueOf(ret);
    }
    private static void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
}
