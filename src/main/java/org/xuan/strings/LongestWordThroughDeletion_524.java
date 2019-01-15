package org.xuan.strings;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xzhou2 on 3/30/17.
 */
public class LongestWordThroughDeletion_524 {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() == b.length() ? a.compareTo(b) : b.length() - a.length();
            }
        }) ;
        for(String w : d) {
            if (isValid(s, w)) {
                return w;
            }
        }
        return "";
    }

    private boolean isValid(String t, String p) {
        if (p.length() > t.length()) {
            return false;
        }
        int index = 0;
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            for(; index < t.length(); index++) {
                if (t.charAt(index) == c) {
                    break;
                }
            }
            if (index++ >= t.length()) {
                return false;
            }
        }
        return true;
    }
}
