package org.xuan.strings;

/**
 * Created by xzhou2 on 1/7/17.
 */
public class ValidAnagram_242 {
    private static final int LEN = 26;
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] cache = new int[LEN];
        for(int i = 0; i < s.length();i++) {
            cache[s.charAt(i) - 'a']++;
            cache[t.charAt(i) - 'a']--;
        }
        for(int i : cache) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
