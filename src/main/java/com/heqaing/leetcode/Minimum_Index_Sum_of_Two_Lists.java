package com.heqaing.leetcode;

import java.util.*;

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
        String[] longList = list1.length>list2.length?list1:list2;
        String[] shortList = list1.length>list2.length?list2:list1;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<longList.length;i++){
            map.put(longList[i],i);
        }
        int[] sumResult = new int[shortList.length];
        int minSum = list1.length+list2.length;
        for(int i=0;i<shortList.length;i++){
            if(map.containsKey(shortList[i])){
                sumResult[i] = i+map.get(shortList[i]);
                if(sumResult[i]<minSum) minSum = sumResult[i];
            }else {
                sumResult[i] = -1;
            }
        }
        List<String> result = new ArrayList<>();
        for (int i=0;i<sumResult.length;i++){
            if(sumResult[i]==minSum) result.add(shortList[i]);
        }
        String[] a = new String[result.size()];
        return result.toArray(a);
    }
}
