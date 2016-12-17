package org.xuan.strings;

/**
 * Created by xzhou2 on 12/15/16.
 */
public class NumOfDecodings_91 {
    public int numDecodings(String s) {
        int[] cache = new int[s.length()];
        if (s.length() > 0 && s.charAt(0) != '0') {
            cache[0] = 1;
        } else {
            return 0;
        }
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i), pre = s.charAt(i - 1);;
            if (c >= '1' && c <= '9') {
                cache[i] += cache[i-1];
            }
            if (pre == '1' || (pre == '2' && c <= '6')) {
                cache[i] += (i > 1 ? cache[i - 2] : 1);
            }

        }
        return cache[cache.length - 1];
    }
}
