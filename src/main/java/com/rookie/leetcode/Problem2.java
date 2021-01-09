package com.rookie.leetcode;

import java.util.*;

public class Problem2 {

    public static void main(String[] args) {
        Problem2 instance = new Problem2();
        int[] names = {2, 3, 0, 0, 3, 1, 0, 1, 0, 2, 2};
        int[] result = instance.avoidFlood(names);
//        Class intClazz = int.class;
        System.out.println(Arrays.toString(result));
    }

    public int[] avoidFlood(int[] rains) {
        int len = rains.length;
        int[] result = new int[len];
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (rains[i] > 0) {
                int removeIndex;
                if (!list.isEmpty() && map.containsKey(rains[i]) && (removeIndex = check(list, map.get(rains[i]))) != -1) {
                    result[list.get(removeIndex)] = rains[i];
                    result[i] = -1;
                    list.remove(removeIndex);
                    map.put(rains[i], i);
                } else {
                    if (map.containsKey(rains[i])) {
                        return new int[0];
                    } else {
                        result[i] = -1;
                        map.put(rains[i], i);
                    }
                }
            } else {
                list.add(i);
                result[i] = 1;
            }
        }
        return result;
    }

    private int check(List<Integer> list, int curIndex) {
        int removeIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > curIndex) {
                removeIndex = i;
                break;
            }
        }
        return removeIndex;

    }
}