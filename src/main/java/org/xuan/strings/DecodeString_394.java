package org.xuan.strings;

import java.util.Stack;

/**
 * Created by xzhou2 on 2/7/17.
 */
public class DecodeString_394 {
    public String decodeString(String s) {
        Stack<int[]> stack = new Stack<>();
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c =='[') {
                stack.push(new int[]{num, sb.length()});
                num = 0;
            } else if (c == ']') {
                addRepeats(sb, stack.pop());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private void addRepeats(StringBuilder sb, int[] pair) {
        String sub = sb.substring(pair[1]);
        for(int i = 0; i < pair[0] - 1; i++) {
            sb.append(sub);
        }
    }
}
