package com.heqaing.leetcode;

import java.util.Arrays;

/**
 * Created by HeQiang on 2018/2/8.
 */

public class String_Compression {
    public static void main(String args[]){
        String_Compression sc = new String_Compression();
        char[] chars = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int len = sc.compress(chars);
        System.out.println(Arrays.toString(chars));
        System.out.println(len);
        System.out.println((char)10);
    }
    public int compress(char[] chars) {
        int len = chars.length;
        char curChar;
        char preChar = chars[0];
        int count = 1;
        int position = 0;
        for(int i=1;i<len;i++){
            curChar = chars[i];
            if(preChar!=curChar){
                position = modifyArray(count,position,preChar,chars);
                preChar = curChar;
                count = 1;
            }else {
                count++;
            }
        }
        position = modifyArray(count,position,preChar,chars);
        return position;
    }
    public int modifyArray(int count,int position,char preChar,char[] chars){
        int bit;
        if(count>=1000){
            bit = 4;
        }else if(count>=100) {
            bit = 3;
        }else if(count>=10){
            bit = 2;
        }else if(count>1){
            bit = 1;
        }else{
            bit = 0;
        }
        chars[position++] = preChar;
        switch (bit){
            case 4:chars[position++] = (char) (48+count/1000);count %= 1000;
            case 3:chars[position++] = (char) (48+count/100);count %= 100;
            case 2:chars[position++] = (char) (48+count/10);count %= 10;
            case 1:chars[position++] = (char) (48+count);
        }
        return position;
    }
}
