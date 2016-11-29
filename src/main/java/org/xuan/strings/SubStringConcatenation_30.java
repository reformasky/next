package org.xuan.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xzhou2 on 11/22/16.
 */
public class SubStringConcatenation_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0 || words[0].length() == 0 || words[0].length() > s.length()) {
            for(int i = 0; i < s.length() - words[0].length(); i++) {
                result.add(i);
            }
            return result;
        }
        int len = words[0].length(), count = words.length;
        Map<String, Integer> indexes = new HashMap<>();
        Map<Integer, Integer> values = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            if(!indexes.containsKey(words[i])) {
                indexes.put(words[i], i);
                values.put(i, 1);
            } else {
                int key = indexes.get(words[i]);
                values.put(key, values.get(key) + 1);
            }
        }
        int[] keys = new int[s.length() - len + 1];
        for(int i = 0; i < keys.length; i++) {
            keys[i] = indexes.getOrDefault(s.substring(i, i + len), -1);
        }
        Map<Integer, Integer> currCount = new HashMap<>();
        for(int i = 0; i < len; i++) {
            currCount = new HashMap<>();
            boolean isValid = true;
            int left = i;
            for(int j = i; j < keys.length; j += len) {
                if (keys[j] < 0) {
                    isValid = false;
                } else {
                    if (!isValid) {
                        isValid = true;
                        left = j;
                        currCount = new HashMap<>();
                        currCount.put(keys[j], 1);
                    } else if (currCount.getOrDefault(keys[j], 0) < values.get(keys[j])) {
                        currCount.put(keys[j], 1 + currCount.getOrDefault(keys[j], 0));
                    } else {
                        while (currCount.get(keys[j]) >= values.get(keys[j])) {
                            currCount.put(keys[left], currCount.get(keys[left]) - 1);
                            left += len;
                        }
                        currCount.put(keys[j], 1 + currCount.get(keys[j])) ;

                    }
                    if (j - left == (count - 1) * len) {
                        result.add(left);
                    }
                }
            }
        }

        return result;
    }


}
