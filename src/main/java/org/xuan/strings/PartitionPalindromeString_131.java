package org.xuan.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 12/18/16.
 */
public class PartitionPalindromeString_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.length() == 0) {
            return result;
        }
        boolean[][] cache = new boolean[s.length()][s.length()];
        @SuppressWarnings("unchecked")
        List<List<String>>[] temp = (List<List<String>>[])new List[s.length()];
        buildCache(s, cache);
        return helper(s, cache, s.length() - 1, temp);
    }


    private List<List<String>> helper(String s, boolean[][] cache, int high, List<List<String>>[] temp) {
        List<List<String>> result = new ArrayList<>();
        if (high <  0) {
            result.add(new ArrayList<>());
            return result;
        }
        if (temp[high] != null) {
            return temp[high];
        }
        for(int i = high; i >= 0; i--) {
            if (cache[i][high]) {
                List<List<String>> pre = helper(s, cache, i  - 1, temp);
                for(List<String> p : pre) {
                    List<String> curr = new ArrayList<>(p);
                    curr.add(s.substring(i, high + 1));
                    result.add(curr);
                }
            }
        }
        temp[high] = result;
        return result;

    }


    private void buildCache(String s, boolean[][] cache) {
        for(int i = 0; i < cache.length; i++) {
            cache[i][i] = true;
        }
        for(int i = 0; i < cache.length - 1; i++) {
            cache[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for(int diff = 2; diff < cache.length; diff++) {
            for(int b = 0; b < cache.length - diff; b++) {
                int e = b + diff;
                cache[b][e] = cache[b + 1][e - 1] && (s.charAt(b) == s.charAt(e));
            }
        }
    }
}
