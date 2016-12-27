package org.xuan.array;

import java.util.Stack;

/**
 * Created by xzhou2 on 12/21/16.
 */
public class ReversePolishEvaluation_150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int left, right;
        for(String s : tokens) {
            if (s.length() == 1 && s.charAt(0) < '0') {
                char c = s.charAt(0);
                right = stack.pop();
                left = stack.pop();
                switch(c) {
                    case '+' : stack.push(left + right); break;
                    case '-' : stack.push(left - right); break;
                    case '*' : stack.push(left * right); break;
                    case '/' : stack.push(left / right); break;
                }

            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.isEmpty() ? 0 : stack.pop();
    }
}
