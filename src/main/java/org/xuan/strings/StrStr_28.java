package org.xuan.strings;

/**
 * Created by xzhou2 on 11/21/16.
 */
public class StrStr_28 {
    public int strStr(String haystack, String needle) {

        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (isMatch(haystack, i, needle)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isMatch(String h, int index, String n) {
        for(int i = 0; i < n.length();i++) {
            if (h.charAt(i + index) != n.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}
