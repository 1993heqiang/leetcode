package com.rookie.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/1.
 */
public class Fizz_Buzz {
    public static void main(String args[]){
        int n = 15;
        long t1 = System.nanoTime();
        List<String> list = fizzBuzz(n);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        for(String i:list){
            System.out.println(i);
        }
    }
    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>();
        for(int i=1;i<=n;i++){
            if(i%15!=0){
                if(i%3==0){
                    list.add("Fizz");
                }else if(i%5==0){
                    list.add("Buzz");
                }else {
                    list.add(""+i);
                }
            }else {
                list.add("FizzBuzz");
            }
        }
        return list;
    }
}
