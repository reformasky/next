package org.xuan.strings;

/**
 * Created by xzhou2 on 4/2/17.
 */
public class LongestUncommonSubstring_521 {
    public int findLUSlength(String a, String b) {
        return a.length() != b.length() ? Math.max(a.length(), b.length()) :
                a.equals(b) ? -1 : a.length();
    }
}
