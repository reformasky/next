package org.xuan.strings;

/**
 * Created by xzhou2 on 12/14/16.
 */
public class ScrambleWords_87 {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return true;
        }
        return isScramble(s1, 0, s1.length() - 1, s2, 0, s2.length() - 1);
    }

    private boolean isScramble(String s1, int low1, int high1, String s2, int low2, int high2) {
        if (low1 == high1) {
            return s1.charAt(low1) == s2.charAt(low2);
        }
        if (! isAnagram(s1, low1, high1, s2, low2, high2)) {
            return false;
        }
        for(int i = low1; i < high1; i++) {
            if ((isScramble(s1, low1, i, s2, low2, i + low2 - low1) && isScramble(s1, i + 1, high1, s2, high2 - high1 + i + 1,high2))||
                    (isScramble(s1, low1, i, s2, high2 - i + low1, high2) && isScramble(s1, i + 1, high1, s2, low2, high1 + low2 - i - 1))) {
                return true;
            }
        }
        return false;
    }

    private boolean isAnagram(String s1, int low1, int high1, String s2, int low2, int high2) {
        int[] count = new int[128];
        for(int i = low1; i <= high1; i++) {
            count[s1.charAt(i)]++;
        }
        for(int i = low2; i <= high2; i++) {
            count[s2.charAt(i)]--;
        }
        for(int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
