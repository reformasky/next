package org.xuan.strings;

import java.util.Arrays;

/**
 * Created by xzhou2 on 1/1/17.
 */
public class IsoMorphicStrings_205 {
    public boolean isIsomorphic(String s, String t) {
        int[] froms = new int[128],
                tos = new int[128];
        Arrays.fill(froms, -1);
        Arrays.fill(tos, -1);
        if (s.length() != t.length()) {
            return false;
        }
        for(int i = 0; i < s.length(); i++) {
            char from = s.charAt(i), to = t.charAt(i);
            if (froms[from] < 0 && tos[to] < 0) {
                froms[from] = to;
                tos[to] = from;
            } else if (froms[from] >= 0 && tos[to] >= 0) {
                if (froms[from] != to || tos[to] != from) {
                    return false;
                }
            } else {
                return false;
            }

        }
        return true;
    }
}
