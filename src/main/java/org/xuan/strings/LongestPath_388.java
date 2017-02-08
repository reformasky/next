package org.xuan.strings;

import java.util.Stack;

/**
 * Created by xzhou2 on 2/6/17.
 */
public class LongestPath_388 {
    public int lengthLongestPath(String input) {
        int result = 0;
        Stack<int[]> stack = new Stack<>();
        int begin = 0, depth = 0;
        boolean isFile = false;
        input = input + '\n';
        for(int e = 0; e < input.length(); e++) {
            char c = input.charAt(e);
            if (c == '\n') {
                while(!stack.isEmpty() && stack.peek()[1] >= depth) {
                    stack.pop();
                }
                int curr = (e - begin + 1) + (stack.isEmpty() ? 0 : stack.peek()[0]);
                if (isFile){
                    result = Math.max(result, curr - 1);
                }
                stack.push(new int[]{curr, depth});
                depth = 0;
                e++;
                while(e < input.length() && input.charAt(e) == '\t') {
                    e++;
                    depth++;
                }
                begin = e;
                e--;
                isFile = false;
            } else if (c == '.') {
                isFile = true;
            }
        }
        return result;
    }
}
