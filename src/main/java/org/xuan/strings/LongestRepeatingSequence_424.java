package org.xuan.strings;

/**
 * Created by xzhou2 on 2/22/17.
 */
public class LongestRepeatingSequence_424 {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int[] counts = new int[26];
        int maxCount = 0;
        for(int i = 0; i < s.length(); i++) {
            maxCount = Math.max(maxCount, ++counts[s.charAt(i) - 'A']);
            if (maxCount + k <= i - start) {
                counts[s.charAt(start++) - 'A']--;
            }
        }
        return s.length() - start;
    }
}
