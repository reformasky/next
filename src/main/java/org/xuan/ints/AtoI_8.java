package org.xuan.ints;

/**
 * Created by xzhou2 on 11/16/16.
 */
public class AtoI_8 {
    public int myAtoi(String str) {
        int limit = Integer.MAX_VALUE / 10;
        int begin = 0, end = str.length() - 1;
        int result = 0;
        boolean sign = true;
        while(begin <= end && str.charAt(begin) == ' ') {
            begin++;
        }
        while(end >= begin && str.charAt(end) == ' '){
            end--;
        }
        char c;
        if (begin <= end) {
            c = str.charAt(begin++);
            if (c == '-') {
                sign = false;
            } else if (isNum(c)) {
                result = c - '0';
            } else if (c != '+') {
                return result;
            }
        }

        while(begin <= end) {
            c = str.charAt(begin++);
            if (!isNum(c)) {
                return sign ? result : -result;
            }
            if (result < limit) {
                result = result * 10 + c - '0';
            } else if (result > limit) {
                return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                return sign ? ((c - '0') >= Integer.MAX_VALUE % 10 ? Integer.MAX_VALUE : result * 10 + c - '0'):
                        ((c - '0') >= (Integer.MAX_VALUE % 10 + 1) ? Integer.MIN_VALUE : -(result * 10 + c - '0'));
            }
        }

        return sign ? result : -result;
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}
