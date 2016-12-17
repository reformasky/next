package org.xuan.strings;

/**
 * Created by xzhou2 on 12/16/16.
 */
public class InterleavingStrings_97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if(len3 != len1 + len2) {
            return false;
        }
        if (len3 == 0) {
            return true;
        }
        byte[][] cache = new byte[len1 + 1][len2 + 1];
        cache[0][0] = 1;
        return helper(cache, s1, len1, s2, len2, s3);
    }

    private boolean helper(byte[][] cache, String s1, int len1, String s2, int len2, String s3) {
        if (cache[len1][len2] != 0) {
            return cache[len1][len2] == 1;
        }
        int len3 = len1 + len2;
        boolean res = false;
        if (len1 == 0) {
            res = s3.charAt(len3 - 1) == s2.charAt(len2 - 1) && helper(cache, s1, len1, s2, len2 - 1, s3);
        } else if (len2 == 0) {
            res = s3.charAt(len3 - 1) == s1.charAt(len1 - 1) && helper(cache, s1, len1 - 1, s2, len2, s3);
        } else if (
                (s3.charAt(len3 - 1) == s2.charAt(len2 - 1) && helper(cache, s1, len1, s2, len2 - 1, s3))||
                        (s3.charAt(len3 - 1) == s1.charAt(len1 - 1) && helper(cache, s1, len1 - 1, s2, len2, s3))
                ){
            res = true;
        }
        cache[len1][len2] = (byte)(res ? 1 : 2);
        return res;
    }
}
