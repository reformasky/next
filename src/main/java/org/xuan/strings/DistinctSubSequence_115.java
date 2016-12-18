package org.xuan.strings;

import java.util.Arrays;

/**
 * Created by xzhou2 on 12/17/16.
 */
public class DistinctSubSequence_115 {
    public int numDistinct(String s, String t) {
        int[] cache = new int[t.length() + 1];
        for(int i = 0; i < s.length(); i++) {
            int tmp = cache[1];
            cache[1] += s.charAt(i) == t.charAt(0) ? 1 : 0;
            for(int j = 1; j < t.length(); j++) {
                int pre = cache[j + 1];
                cache[j + 1] += s.charAt(i) == t.charAt(j) ? tmp : 0;
                tmp = pre;
            }

        }
        return cache[t.length()];
    }
}
