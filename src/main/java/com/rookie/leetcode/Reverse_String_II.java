package com.rookie.leetcode;

/**
 * Created by Administrator on 2017/3/23 0023.
 */
public class Reverse_String_II {
    public static void main(String args[]){
        String s = "abcdefghi";
        int k = 3;
        String ret = reverseStr(s,k);
        System.out.println(ret);
    }
    public static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while(i < n) {
            int j = Math.min(i + k - 1, n - 1);
            swap(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }
    private static void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
}
