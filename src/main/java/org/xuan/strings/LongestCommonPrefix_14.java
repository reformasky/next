package org.xuan.strings;

/**
 * Created by xzhou2 on 11/16/16.
 */
public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        int len = Integer.MAX_VALUE, i;
        if (strs.length == 0) {
            return "";
        }
        for(String s : strs) {
            len = Math.min(len, s.length());
        }
        for(i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0].substring(0,i);
    }
}
