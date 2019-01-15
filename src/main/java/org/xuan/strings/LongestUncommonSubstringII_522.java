package org.xuan.strings;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by xzhou2 on 4/2/17.
 */
public class LongestUncommonSubstringII_522 {
    public int findLUSlength(String[] strs) {
        TreeMap<Integer, Set<String>> map = new TreeMap<>();
        Set<String> duplicates = new HashSet<>();
        for(String s : strs) {
            int len = s.length();
            Set<String> curr;
            if (!map.containsKey(len)) {
                curr = new HashSet<>();
                map.put(len, curr);
            } else {
                curr = map.get(len);
            }
            if (!curr.add(s)) {
                duplicates.add(s);
            }
        }

        for(Integer k : map.descendingKeySet()) {
            Set<String> curr = map.get(k);
            for(String c : curr) {
                if (!duplicates.contains(c)) {
                    boolean valid = true;
                    for(Integer l : map.descendingKeySet()) {
                        if (l <= k || !valid) {
                            break;
                        }
                        Set<String> larger = map.get(l);
                        for(String s : larger) {
                            if (invalid(s, c)) {
                                valid = false;
                                break;
                            }
                        }
                    }
                    if (valid) {
                        return k;
                    }
                }
            }
        }
        return -1;
    }


    private boolean invalid(String text, String pattern) {
        // System.out.println(text + "  " + pattern);
        int indexT = 0, indexP = 0;
        for(; indexP < pattern.length(); indexP++) {
            char p = pattern.charAt(indexP);
            boolean found = false;
            for(; indexT < text.length(); indexT++) {
                if (text.charAt(indexT) == p) {
                    indexT++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}
