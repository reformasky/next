package org.xuan.strings;

/**
 * Created by xzhou2 on 1/5/17.
 */
public class BasicCalculatorII_227 {
    public int calculate(String s) {
        s = s + "+";
        int pre = 0, left = 0, curr = 0, op = 0;
        boolean sign = true;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                curr = curr * 10 + c - '0';
            } else if (c != ' ') {
                if (op == 1) {
                    curr = left * curr;
                    op = 0;
                } else if (op == 2) {
                    curr = left / curr;
                    op = 0;
                }
                if (c == '+' || c == '-') {
                    pre += sign ? curr : - curr;
                    sign = c == '+';
                } else if (c == '*'  || c == '/') {
                    op = c == '*' ? 1 : 2;
                    left = curr;
                }
                curr = 0;
            }
        }
        return pre;
    }
}
