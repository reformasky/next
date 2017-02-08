package org.xuan.strings;

/**
 * Created by xzhou2 on 2/6/17.
 */
public class FindDifference_389 {
    public char findTheDifference(String s, String t) {
        int[] counts = new int[26];
        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++) {
            counts[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if (counts[i] != 0) {
                return (char)(i + 'a');
            }
        }
        throw new RuntimeException();
    }
}
