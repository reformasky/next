package org.xuan.strings;

/**
 * Created by xzhou2 on 11/15/16.
 */
public class LongestPalindromeSubString_5 {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int len = 0, center = 0;
        boolean isMid = true;
        for(int i = 0; i < s.length(); i++) {
            if (2 * (s.length() - i) - 1 <= len) {
                break;
            }
            int curr = helper(s, i, true);
            if (curr > len) {
                len = curr;
                center = i;
            }

        }
        for(int i = 0; i < s.length(); i++) {
            if (2 * (s.length() - i - 1) <= len) {
                break;
            }
            int curr = helper(s, i, false);
            if (curr > len) {
                len = curr;
                center = i;
                isMid = false;
            }
        }
        int half = len / 2;
        return isMid ? s.substring(center - half, center + half + 1) :
                s.substring(center - half + 1 ,center + half + 1);
    }

    private int helper(String s, int center, boolean isMid) {
        int res = isMid ? 1 : 0, left = isMid ? center - 1: center, right = center + 1;
        while(left >= 0 && right < s.length()) {
            if (s.charAt(left--) == s.charAt(right++)) {
                res += 2;
            } else {
                break;
            }
        }
        return res;
    }
}
