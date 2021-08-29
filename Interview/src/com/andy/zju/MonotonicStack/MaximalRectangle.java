package com.andy.zju.MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    temp[i][j] = matrix[i][j] == '0' ? 0 : 1;
                } else {
                    temp[i][j] = matrix[i][j] == '0' ? 0 : temp[i-1][j] + 1;
                }
            }
        }
        int res = 0;
        for (int[] t : temp) {
            res = Math.max(res, largestRectangle(t));
        }
        return res;
    }

    public int largestRectangle(int[] heights) {
        int n = heights.length;
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0 ; i < n; i++) {
            while(stack.size() > 0 && heights[stack.peek()] > heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
            right[i] = n;
            
        }

        int[] left = new int[n];
        stack.clear();
        for(int i = n-1 ; i >=0; i--) {
            while(stack.size() > 0 && heights[stack.peek()] > heights[i]) {
                left[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
            left[i] = -1;
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] -1));
        }
        return max;

    }
}
