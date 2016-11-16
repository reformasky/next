package org.xuan.strings;

import java.util.Arrays;

/**
 * Created by xzhou2 on 11/10/16.
 */
public class LongestSubStringWithoutDuplicate_3 {
    public int lengthOfLongestSubstring(String s) {
        int[] indexes = new int[128];
        Arrays.fill(indexes, -1);
        int begin = 0, res = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            begin = Math.max(begin, indexes[c] + 1);
            res = Math.max(res, i - begin + 1);
            indexes[c] = i;
        }
        return res;
    }
}
