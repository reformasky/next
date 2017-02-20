package org.xuan.strings;

import java.util.Stack;

/**
 * Created by xzhou2 on 2/17/17.
 */
public class RemoveKDigits_402 {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        if (k == 0) {
            return num;
        }
        int zeroIndex = num.indexOf("0");
        if (zeroIndex >= 0 && zeroIndex <= k) {
            return removeKdigits(num.substring(zeroIndex + 1), k - zeroIndex);
        }
        char val = num.charAt(0);
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while(!stack.isEmpty() && stack.peek() > c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while(k-- > 0) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
