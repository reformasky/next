package org.xuan.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 12/11/16.
 */
public class MinWindowSubString_76 {
    private static final int total = 128;
    public String minWindow(String s, String t) {
        int begin = 0, end = s.length(), count = 0, left = 0;
        int[] sMap = new int[total],
                tMap = new int[total];
        for(int i = 0; i < t.length(); i++) {
            tMap[t.charAt(i)]++;
        }
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (sMap[curr] < tMap[curr]) {
                count++;
            }
            sMap[curr]++;
            if (count == t.length()) {
                while(left < i + 1 && (sMap[s.charAt(left)] > tMap[s.charAt(left)] || tMap[s.charAt(left)] == 0)) {
                    sMap[s.charAt(left++)]--;
                }
                if (i - left + 1 < end - begin) {
                    end = i + 1;
                    begin = left;
                }
            }
        }
        return count == t.length() ? s.substring(begin, end) : "";
    }
}
