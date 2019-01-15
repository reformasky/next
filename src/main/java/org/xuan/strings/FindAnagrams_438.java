package org.xuan.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 2/23/17.
 */
public class FindAnagrams_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] count = new int[26];
        int pLen = p.length();
        for(int i = 0; i < pLen; i++) {
            count[p.charAt(i) - 'a']--;
            count[s.charAt(i) - 'a']++;
        }
        boolean isValid = isValid(count);
        if (isValid) {
            result.add(0);
        }
        for(int i = pLen; i < s.length(); i++) {
            int index = s.charAt(i) - 'a', pre = s.charAt(i - pLen) - 'a';
            if (isValid && index == pre) {
                result.add(i - pLen + 1);
            } else {
                count[index]++;
                count[pre]--;
                if (count[index] == 0 && isValid(count)) {
                    result.add(i - pLen + 1);
                    isValid = true;
                } else {
                    isValid = false;
                }

            }
        }
        return result;
    }

    private boolean isValid(int[] count) {
        for(int i = 0; i < 25; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
