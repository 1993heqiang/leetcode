package com.rookie.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2016/11/1.
 */
public class Binary_Watch {
    public static void main(String args[]){
        //1<= n <=8
        int n = 1;
        long t1 = System.nanoTime();
        List<String> list = readBinaryWatch(n);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        for(String i:list){
            System.out.println(i);
        }


    }
    public static List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<String>();
        for(int i=0;i<=num&&i<4;i++){
            if(num-i<6){
                list.addAll(subfunction(i,num-i));
            }
        }
        return list;
    }
    public static List<String> subfunction(int hourBit,int minuteBit){
        List<String> list = new ArrayList<String>();
        List<Integer> hourArr = hour(hourBit);
        List<Integer> minuteArr = minute(minuteBit);
        for(int i=0;i<hourArr.size();i++){
            if(hourArr.get(i)<12){
                for(int j=0;j<minuteArr.size();j++){
                    if(minuteArr.get(j)<=59){
                        if(minuteArr.get(j)<10){
                            list.add(hourArr.get(i)+":0"+minuteArr.get(j));
                        }else {
                            list.add(hourArr.get(i)+":"+minuteArr.get(j));
                        }
                    }
                }
            }
        }
        return list;
    }
    public static List<Integer> hour(int num){
        int[] temp = {1,2,4,8};
        List<Integer> list = test(temp,num,0);
        return list;
    }
    public static List<Integer> minute(int num){
        int[] temp = {1,2,4,8,16,32};
        List<Integer> list = test(temp,num,0);
        return list;
    }
    public static List<Integer> test(int[] arr,int bit,int begin){
        List<Integer> list = new ArrayList<Integer>();
        if(bit>1){
            List<Integer> subList;
            for(int i=begin;i<=arr.length-bit;i++){
                subList = test(arr,bit-1,i+1);
                for(int j=0;j<subList.size();j++){
                    subList.set(j,subList.get(j)+arr[i]);
                }
                list.addAll(subList);
            }
        }else if(bit==1) {
            for(int i=begin;i<=arr.length-bit;i++){
                list.add(arr[i]);
            }
        }else{
            list.add(0);
        }
        return list;
    }
}
