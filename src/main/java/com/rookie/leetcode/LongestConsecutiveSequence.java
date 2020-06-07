package com.rookie.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence instance = new LongestConsecutiveSequence();
        int[] input = {100, 4, 200, 1, 3, 2};
        System.out.println(instance.longestConsecutive(input));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int begin = num;
                while (set.contains(++begin)) ;
                result = Math.max(result, begin - num);
            }
        }
        return result;
    }
}
