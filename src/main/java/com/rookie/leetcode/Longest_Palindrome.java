package com.rookie.leetcode;

/**
 * Created by Administrator on 2016/11/1.
 */
public class Longest_Palindrome {
    public static void main(String args[]){
        String s = "abccccdd";
        long t1 = System.nanoTime();
        int len = longestPalindrome(s);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(len);
    }
    public static int longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int[] newArr = new int[52];
        for(int i=0;i<arr.length;i++){
            if('a'>arr[i]){
                newArr[arr[i]-'A']++;
            }else{
                newArr[arr[i]-'a'+26]++;
            }
        }
        int _result = 0;
        for(int i=0;i<newArr.length;i++){
            if(newArr[i]!=0){
                _result+=newArr[i]%2;
            }
        }
        return _result==0?arr.length:arr.length-_result+1;
    }
}
