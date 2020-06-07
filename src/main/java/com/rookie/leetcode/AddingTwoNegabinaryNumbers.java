package com.rookie.leetcode;

import java.util.Arrays;

public class AddingTwoNegabinaryNumbers {
    public static void main(String[] args) {
        AddingTwoNegabinaryNumbers instance = new AddingTwoNegabinaryNumbers();
        int[] arr1 = {1, 0, 1, 0, 1};
        int[] arr2 = {1, 0, 1};
        int[] result = instance.addNegabinary(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int arr1Len = arr1.length;
        int arr2Len = arr2.length;
        if (arr1Len == 0 && arr2Len == 0) {
            return new int[0];
        }
        int[] result = new int[Math.max(arr1Len, arr2Len) + 2];
        int resultLen = result.length;
        int index = 0;
        while (index < arr1Len && index < arr2Len) {
            result[resultLen - 1 - index] = arr1[arr1Len - 1 - index] + arr2[arr2Len - 1 - index];
            index++;
        }
        while (index < arr1Len) {
            result[resultLen - 1 - index] = arr1[arr1Len - 1 - index];
            index++;
        }
        while (index < arr2Len) {
            result[resultLen - 1 - index] = arr2[arr2Len - 1 - index];
            index++;
        }
        index = resultLen - 1;
        while (index >= 2) {
            if (result[index] == 2 || result[index] == 3) {
                result[index] -= 2;
                if (result[index - 1] == 0) {
                    result[index - 1] += 1;
                    result[index - 2] += 1;
                } else {
                    result[index - 1] -= 1;
                }
            }
            index--;
        }
        index = 0;
        while (index < resultLen - 1) {
            if (result[index] != 0) {
                break;
            }
            index++;
        }
        return Arrays.copyOfRange(result, index, resultLen);
    }
}
