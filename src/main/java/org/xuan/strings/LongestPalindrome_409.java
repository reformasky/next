package org.xuan.strings;

/**
 * Created by xzhou2 on 2/20/17.
 */
public class LongestPalindrome_409 {
    public int longestPalindrome(String s) {
        int[] counts = new int[128];
        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)]++;
        }
        boolean hasOdd = false;
        int result = 0;
        for(int c : counts) {
            result += c / 2 * 2;
            if (c % 2 == 1) {
                hasOdd = true;
            }
        }
        return hasOdd ? result + 1 : result;
    }
}
