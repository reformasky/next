package org.xuan.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by xzhou2 on 12/26/16.
 */
public class WordBreakII_140 {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s.length() == 0 || wordDict.isEmpty()) {
            return result;
        }
        @SuppressWarnings("unchecked")
        List<String>[] cache = (List<String>[]) new List[s.length()];
        return helper(cache, s.length() - 1, s, wordDict);
    }

    private List<String> helper(List<String>[] cache, int index, String s, Set<String> wordDict) {
        if (cache[index] != null) {
            return cache[index];
        }

        List<String> curr = new ArrayList<>();
        if (wordDict.contains(s.substring(0, index + 1))) {
            curr.add(s.substring(0, index + 1));
        }
        for(int i = 1; i <= index; i++) {
            String tmp = s.substring(i, index + 1);
            if (wordDict.contains(tmp)) {
                List<String> pre = helper(cache, i - 1, s, wordDict);
                for(String p : pre) {
                    curr.add(p + " " + tmp);
                }
            }
        }
        cache[index] = curr;
        return curr;
    }
}
