package org.xuan.strings;

/**
 * Created by xzhou2 on 3/30/17.
 */
public class LongestPalindromeSubsequence_516 {
    public int longestPalindromeSubseq(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int len = s.length();
        int[][] cache = new int[len][len];
        for(int i = 0; i < len; i++) {
            cache[i] = new int[len];
            cache[i][i] = 1;
        }
        for(int l = 2; l <= len; l++) {
            for(int low = 0; low + l - 1 < len; low++) {
                int high = low + l - 1;
                if (s.charAt(low) == s.charAt(high)) {
                    cache[low][high] = 2 + cache[low +1][high - 1];
                } else {
                    cache[low][high] = Math.max(cache[low + 1][high], cache[low][high - 1]);
                }
            }
        }
        return cache[0][len - 1];
    }
}
