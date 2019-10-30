package com.rookie.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by HeQiang on 2017-06-02 17:13.
 */
public class Distribute_Candies {
    public static void main(String[] args){
        int[] candies = {1,1,2,2,3,3};
        long t1 = System.nanoTime();
        int result = distributeCandies(candies);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(result);
    }
    public static int distributeCandies(int[] candies){
        Set<Integer> candyKinds = new HashSet<>();
        for(int i=0;i<candies.length;i++){
            candyKinds.add(candies[i]);
        }
        if((candies.length/2)>candyKinds.size()){
            return candyKinds.size();
        }else {
            return candies.length/2;
        }
    }
}
