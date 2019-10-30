package com.rookie.leetcode;

/**
 * Created by Administrator on 2016/9/7.
 */
public class Nim_Game {
    public static void main(String args[]){
        int n = 10;
        int temp = n%4;
        if(temp==0){
            System.out.println(false);
        }else{
            System.out.println(true);
        }
    }
}
