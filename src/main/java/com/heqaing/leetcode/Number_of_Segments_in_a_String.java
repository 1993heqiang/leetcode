package com.heqaing.leetcode;

/**
 * Created by Administrator on 2017/1/12.
 */
public class Number_of_Segments_in_a_String {
    public static void main(String args[]){
        String s = " Hello, my name is John";
        long t1 = System.nanoTime();
        int ret = countSegments(s);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int countSegments(String s) {
        char[] arr = s.toCharArray();
        if (arr.length== 0) return 0;
        int count = arr[0] != ' ' ? 1 : 0;
        for (int i = 1; i < arr.length; i++)
        {
            count += arr[i] != ' ' && arr[i-1] == ' ' ? 1 : 0;
        }
        return count;
    }
}
