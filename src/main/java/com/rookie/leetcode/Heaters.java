package com.rookie.leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/1/12.
 */
public class Heaters {
    public static void main(String args[]){
        int[] houses = {2,3,4,6,8};
        int[] heaters = {1,10};
        long t1 = System.nanoTime();
        int ret = findRadius(houses,heaters);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int len = heaters.length-1;
        int i = 0, res = 0;
        for (int house : houses) {
            while (i < len && heaters[i] + heaters[i + 1] <= house * 2) {
                i++;
            }
            res = Math.max(res, Math.abs(heaters[i] - house));
        }

        return res;
    }
}
