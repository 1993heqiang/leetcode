package com.heqaing.leetcode;

import java.util.Arrays;

/**
 * Created by HeQiang on 2017-06-02 18:02.
 */
public class Minimum_Index_Sum_of_Two_Lists {
    public static void main(String[] args){
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        long t1 = System.nanoTime();
        String[] result = findRestaurant(list1,list2);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(Arrays.toString(result));
    }
    public static String[] findRestaurant(String[] list1, String[] list2) {
        return null;
    }
}
