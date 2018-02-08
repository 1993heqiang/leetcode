package com.heqaing.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HeQiang on 2017/10/7.
 */

public class BaseballGame {
    public static void main(String args[]){
        String[] ops =  {"5","-2","4","C","D","9","+","+"};
        int ret = calPoints(ops);
        System.out.println(ret);

    }
    public static int calPoints(String[] ops) {
        int len = ops.length;
        if(len==0) return 0;
        int[] arr = new int[len];
        int pos = 0, ret = 0;
        String temp;
        for(int i=0;i<len;i++){
            temp = ops[i];
            if("C".equals(temp)){
                ret -= arr[pos-1];
                pos -= 2;
            }else if("D".equals(temp)){
                arr[pos] = 2 * arr[pos-1];
                ret += arr[pos];
            }else if("+".equals(temp)){
                arr[pos] = arr[pos-1] + arr[pos-2];
                ret += arr[pos];
            }else {
                arr[pos] = Integer.valueOf(temp);
                ret += arr[pos];
            }
            pos ++;
        }
        return ret;
    }
}
