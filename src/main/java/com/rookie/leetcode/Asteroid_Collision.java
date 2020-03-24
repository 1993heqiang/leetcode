package com.rookie.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Asteroid_Collision {
    public static void main(String[] args) {
        Asteroid_Collision instance = new Asteroid_Collision();
        int[] input = new int[]{1, -2, -2, -2};
        int[] result = instance.asteroidCollision(input);
        System.out.println(Arrays.toString(result));
    }

    public int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        if (len < 2) {
            return asteroids;
        }
        Deque<Integer> deque = new LinkedList<>();
        int cur = 0;
        for (int i = 0; i < len; i++) {
            if (cur == 0) {
                if (asteroids[i] < 0) {
                    deque.addLast(asteroids[i]);
                } else if (asteroids[i] > 0) {
                    cur = asteroids[i];
                }
            } else {
                int temp = asteroids[i];
                if (temp < 0) {
                    int absVal = Math.abs(temp);
                    if (cur < absVal) {
                        cur = 0;
                        Integer last = deque.peekLast();
                        if (last != null && last > 0) {
                            i--;
                            cur = deque.removeLast();
                        } else {
                            deque.addLast(temp);
                        }
                    } else if (absVal == cur) {
                        cur = 0;
                        Integer last = deque.peekLast();
                        if (last != null && last > 0) {
                            cur = deque.removeLast();
                        }
                    }
                } else {
                    deque.addLast(cur);
                    cur = temp;
                }
            }
        }
        if (cur != 0) {
            deque.addLast(cur);
        }
        int newLen = deque.size();
        int[] result = new int[newLen];
        for (int i = 0; i < newLen; i++) {
            result[i] = deque.removeFirst();
        }
        return result;
    }
}
