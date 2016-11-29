package org.xuan.strings;

import java.util.Stack;

/**
 * Created by xzhou2 on 11/28/16.
 */
public class LongestValidParenthesis_32 {
    public int longestValidParentheses(String s) {
        s = ')' + s;
        int[] cache = new int[s.length()];
        int result = 0;
        for(int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')' && s.charAt(i - 1 - cache[i - 1]) == '(') {
                cache[i] = 2 + cache[i-1] + cache[i - 2 - cache[i-1]];
                result = Math.max(cache[i], result);
            }
        }
        return result;
    }

    public int longestValidParentheses_stack(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int len = s.length(), result = 0;
        int[] cache = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    int left = stack.pop(), currLen = i - left + 1;
                    if (left > 0) {
                        currLen += cache[left-1];
                    }
                    cache[i] = currLen;
                    result = Math.max(result, currLen);
                }
            }
        }
        return result;
    }
}

