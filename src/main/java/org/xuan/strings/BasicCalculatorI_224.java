package org.xuan.strings;

import java.util.Stack;

/**
 * Created by xzhou2 on 1/5/17.
 */
public class BasicCalculatorI_224 {
    public int calculate(String s) {
        s = s + " ";
        Stack<Integer> value = new Stack<>();
        Stack<Boolean> sign = new Stack<>();
        int curr = 0, left = 0;
        boolean plus = true;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                curr = 10 * curr + c - '0';

            } else {
                left += plus ? curr : -curr;
                if (c == '-') {
                    plus = false;
                } else if (c == '+') {
                    plus = true;
                } else if (c == '(') {
                    value.push(left);
                    left = 0;
                    sign.push(plus);
                    plus = true;
                } else if (c == ')'){
                    curr = left;
                    left = value.isEmpty() ? 0 : value.pop();
                    plus = sign.isEmpty() ? true : sign.pop();
                    left += plus ? curr : - curr;
                }
                curr = 0;
            }
        }
        return left;
    }
}
