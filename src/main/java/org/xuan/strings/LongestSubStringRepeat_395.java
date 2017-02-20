package org.xuan.strings;

import java.util.Arrays;

/**
 * Created by xzhou2 on 2/7/17.
 */
public class LongestSubStringRepeat_395 {
    public int longestSubstring(String s, int k) {
        if (k <= 1) {
            return s.length();
        }
        int result = 0;
        int[] cache = new int[26];
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            cache[index]++;
            if (cache[index] >= k) {
                int[] cp = Arrays.copyOf(cache, 26);
                for(int j = 0; cp[index] >= k; j++) {
                    if (isValid(cp,k)) {
                        result = Math.max(result, i - j + 1);
                        break;
                    }
                    cp[s.charAt(j)]--;
                }
            }
        }
        return result;
    }

    private boolean isValid(int[] arr, int k) {
        for(int a : arr) {
            if (a > 0 && a < k) {
                return false;
            }
        }
        return true;
    }


}
