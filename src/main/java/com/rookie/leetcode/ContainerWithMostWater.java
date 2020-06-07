package com.rookie.leetcode;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater example = new ContainerWithMostWater();
        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(example.maxArea(input));
    }

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(area, max);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

}
