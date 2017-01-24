package org.xuan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xzhou2 on 1/22/17.
 */
public class PalindromePairs_336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words.length < 2) {
            return result;
        }
        @SuppressWarnings("unchecked")
        Set<String>[] prefixs = (Set<String>[]) new Set[words.length],
                reversedSuffixs = (Set<String>[]) new Set[words.length];
        for(int i = 0; i < words.length; i++) {
            prefixs[i] = prefix(words[i], true);
            reversedSuffixs[i] = reversedSuffix(words[i]);
        }
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for(int i = 0; i < words.length; i++) {
            for(String s : prefixs[i]) {
                if (map.containsKey(s)) {
                    int j = map.get(s);
                    if (i != j) {
                        result.add(Arrays.asList(i, j));
                    }
                }
            }
            for(String s : reversedSuffixs[i]) {
                if (map.containsKey(s) && ! s.equals(new StringBuilder(words[i]).reverse().toString()) ) {
                    int j = map.get(s);
                    if (i != j) {
                        result.add(Arrays.asList(j, i));
                    }
                }
            }
        }

        return result;
    }

    private Set<String> reversedSuffix(String s) {
        return prefix(new StringBuilder(s).reverse().toString(), false);
    }

    private Set<String> prefix(String s, boolean reverse) {
        Set<String> result = new HashSet<>();
        for(int i = 0; i <= s.length(); i++) {
            if (isPalindrome(s, i, s.length() - 1)) {
                String curr = s.substring(0, i);
                result.add(reverse ? new StringBuilder(curr).reverse().toString() : curr);
            }
        }
        return result;
    }

    private boolean isPalindrome(String s, int begin, int end) {
        while(begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
