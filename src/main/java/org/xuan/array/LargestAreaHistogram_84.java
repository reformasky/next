package org.xuan.array;

import java.util.Stack;

/**
 * Created by xzhou2 on 12/13/16.
 */
public class LargestAreaHistogram_84 {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < heights.length; i++) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
            } else {
                while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    int index = stack.pop();
                    int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                    result = Math.max(result, width * heights[index]);
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()) {
            int index = stack.pop();
            int width = stack.isEmpty() ? heights.length : (heights.length - stack.peek() - 1);
            result = Math.max(result, width * heights[index]);
        }
        return result;
    }
}
