package org.xuan.strings;

import java.util.Set;

/**
 * Created by xzhou2 on 12/19/16.
 */
public class WordBreak_139 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        boolean[] cache = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j >= 0; j--) {
                if ((j == 0 ||cache[j - 1]) && wordDict.contains(s.substring(j, i+ 1))) {
                    cache[i] = true;
                    break;
                }
            }
        }
        return cache[s.length() - 1];
    }
}
