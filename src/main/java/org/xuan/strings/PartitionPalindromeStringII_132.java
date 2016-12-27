package org.xuan.strings;

import java.util.Arrays;

/**
 * Created by xzhou2 on 12/18/16.
 */
public class PartitionPalindromeStringII_132 {
    int len = 0;
    public int minCut(String s) {
        if(s.length() < 2) {
            return 0;
        }
        len = s.length();
        boolean[][] isPalindrome = new boolean[len][len];
        buildCache(s, isPalindrome);
        int[] cache = new int[len];
        Arrays.fill(cache, -1);
        return helper(isPalindrome, cache, 0);
    }

    private int helper(boolean[][] isPalindrome, int[] cache, int low) {
        if (low >= len) {
            return -1;
        }
        if (cache[low] >= 0) {
            return cache[low];
        }
        int result = Integer.MAX_VALUE;
        for(int i = low; i < len; i++) {
            if (isPalindrome[low][i]) {
                result = Math.min(1 + helper(isPalindrome, cache, i + 1), result);
            }
        }
        cache[low] = result;
        return result;
    }

    private void buildCache(String s, boolean[][] isPalindrome) {
        for(int i = 0; i < len; i++) {
            isPalindrome[i][i] = true;
        }
        for(int i = 0; i < len - 1; i++) {
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for(int diff = 2; diff < len; diff++) {
            for(int b = 0; b < len - diff; b++) {
                int e = b + diff;
                isPalindrome[b][e] = isPalindrome[b + 1][ e - 1] && s.charAt(b) == s.charAt(e);
            }
        }
    }
}
