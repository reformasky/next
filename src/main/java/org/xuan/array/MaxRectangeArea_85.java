package org.xuan.array;

import java.util.Stack;

/**
 * Created by xzhou2 on 12/14/16.
 */
public class MaxRectangeArea_85 {
    public int maximalRectangle(char[][] matrix) {
        int result = 0;
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int[] heights = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < heights.length; j++) {
                heights[j] = matrix[i][j] == '0' ? 0 : (heights[j] + 1);
            }
            result = Math.max(result,maxHistogram(heights));
        }
        return result;
    }

    private int maxHistogram(int[] h) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int[] tmp = new int[h.length + 1];
        for(int i = 0; i < h.length; i++) {
            tmp[i] = h[i];
        }
        for(int i = 0; i < tmp.length; i++) {
            while(!stack.isEmpty() && tmp[stack.peek()] > tmp[i]) {
                int index = stack.pop();
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                result = Math.max(result, width * tmp[index]);
            }
            stack.push(i);
        }
        return result;
    }
}
