package com.andy.cow.MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < T.length; i++) {
            while(!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int dayIndex = stack.pop();
                res[dayIndex] = i - dayIndex;
            }
            stack.push(i);
        }
        return res;
    }
}
