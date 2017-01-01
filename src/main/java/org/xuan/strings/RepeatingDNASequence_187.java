package org.xuan.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xzhou2 on 12/29/16.
 */
public class RepeatingDNASequence_187 {
    private int len = 10;
    private int base = 4;
    private int mask = 1;
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() <= len) {
            return res;
        }
        for(int i = 1; i < len; i++) {
            mask *= base;
        }
        int curr = 0;
        Set<Integer> set = new HashSet<>(), added = new HashSet<>();

        for(int i = 0; i < len; i++) {
            curr = base * curr + map(s.charAt(i));
        }
        set.add(curr);
        for(int i = len; i < s.length(); i++) {
            curr %= mask;
            curr = base * curr + map(s.charAt(i));
            if (!set.add(curr) && added.add(curr)) {
                res.add(s.substring(i - len + 1 , i+ 1));
            }
        }
        return res;
    }

    private int map(char c) {
        switch(c) {
            case 'A': return 0;
            case 'T': return 1;
            case 'G': return 2;
            case 'C': return 3;
        }
        throw new RuntimeException();
    }
}
