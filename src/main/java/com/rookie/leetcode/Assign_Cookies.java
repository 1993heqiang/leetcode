package com.rookie.leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/1/10.
 */
public class Assign_Cookies {
    public static void main(String args[]){
        int[] g = {1,2};
        int[] s = {1,2,3};
        long t1 = System.nanoTime();
        int ret = findContentChildren(g,s);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ret = 0;
        int position = g.length,temp;
        for(int i=s.length-1;i>=0;i--){
            temp = position;
            for(int j=position-1;j>=0;j--){
                if(s[i]>=g[j]){
                    position = j;
                    ret++;
                    break;
                }
            }
            if(temp==position) break;
        }
        return ret;
    }
}
