package org.xuan.strings;

/**
 * Created by xzhou2 on 12/7/16.
 */
public class ValidNumber_65 {
    public boolean isNumber(String s) {
        boolean signAllowed = true, dotAllowed = true, eAllowed = true, intFound = false;
        int begin = 0, end = s.length() - 1;
        while(begin <= end && s.charAt(begin) == ' ') {
            begin++;
        }
        while(end >= begin && s.charAt(end) == ' ') {
            end--;
        }
        if (begin > end) {
            return false;
        }
        for(int i = begin; i <= end; i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                if (signAllowed) {
                    return false;
                }
                signAllowed = false;
            } else if (c == '.') {
                if (!dotAllowed) {
                    return false;
                }
                dotAllowed = false;
                signAllowed = false;
            } else if (c == 'e') {
                if( !eAllowed || !intFound) {
                    return false;
                }
                dotAllowed = false;
                eAllowed = false;
                intFound = false;
                signAllowed = true;
            } else if (c >= '0' && c <= '9') {
                intFound = true;
                signAllowed = false;
            } else {
                return false;
            }
        }

        return intFound;
    }
}
