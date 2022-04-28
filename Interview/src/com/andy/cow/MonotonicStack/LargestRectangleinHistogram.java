package com.andy.cow.MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();

        int[] right = new int[n];

        for(int i = 0; i < n; i++) {
            while(stack.size() > 0 && heights[stack.peek()] > heights[i]) {
                right[stack.peek()]  = i;
                stack.pop();
            }
            stack.push(i);
            right[i] = n;
        }



        int[] left = new int[n];

        for(int i = n - 1; i >= 0; i--) {
            while(stack.size() > 0 && heights[stack.peek()] > heights[i]) {
                left[stack.peek()]  = i;
                stack.pop();


            }
            stack.push(i);
            left[i] = -1;
        }

        int res = 0;

        for(int i = 0; i < n; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] -1));
        }

        return res;

    }
}
