package org.xuan.strings;

/**
 * Created by xzhou2 on 11/16/16.
 */
public class RegularExpressionMatch_10 {
    public boolean isMatch(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        if (len2 == 0) {
            return len1 == 0;
        }
        boolean[][] cache = new boolean[len1 + 1][len2 + 1];
        cache[0][0] = true;
        cache[0][1] = false;
        for(int i = 2; i <= len2; i++) {
            cache[0][i] = p.charAt(i - 1) == '*' && cache[0][i - 2];
        }
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                char c = p.charAt(j - 1);
                if (c == '.') {
                    cache[i][j] = cache[i - 1][j - 1];
                } else if (c == '*') {
                    //zero
                    if (cache[i][j-1]) {
                        cache[i][j] = true;
                    } else {
                        //1 or more
                        char pre = p.charAt(j - 2);
                        for(int k = i; k >= 0; k--) {
                            if (cache[k][j - 2] && isMatch(s, k, i, pre)) {
                                cache[i][j] = true;
                                break;
                            }
                        }
                    }

                } else {
                    cache[i][j] = cache[i-1][j-1] && c == s.charAt(i - 1);
                }
            }
        }
        return cache[len1][len2];
    }

    private boolean isMatch(String s, int begin, int end, char c) {
        if (c == '.') {
            return true;
        }
        for(int i = begin; i < end; i++) {
            if (s.charAt(i) != c) {
                return false;
            }
        }
        return true;
    }
}
