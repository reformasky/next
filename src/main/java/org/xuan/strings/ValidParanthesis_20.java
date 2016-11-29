package org.xuan.strings;

import java.util.Stack;

/**
 * Created by xzhou2 on 11/18/16.
 */
public class ValidParanthesis_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case '(':;
                case '[':;
                case '{': stack.push(c);break;
                default:
                    if (stack.isEmpty() || !isValid(stack.pop(), c)) {
                        return false;
                    }

            }
        }
        return stack.isEmpty();
    }

    private boolean isValid(char left, char right) {
        switch (left) {
            case '(': return right == ')';
            case '[': return right == ']';
            case '{': return right == '}';
        }
        return false;
    }
}
