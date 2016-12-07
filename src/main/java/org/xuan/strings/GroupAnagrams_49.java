package org.xuan.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by xzhou2 on 12/2/16.
 */
public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Key, List<String>> map = new HashMap<>();
        for(String str : strs) {
            Key key = new Key(str);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());

    }

    static class Key{
        int[] count = new int[26];
        int len;

        public Key(String str) {
            for(int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }
            len = str.length();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            if(len != key.len) {
                return false;
            }
            for(int i = 0; i < 26; i++) {
                if (key.count[i] != count[i]) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            int prime = 31, base = Integer.MAX_VALUE / 4;
            int res = 0;
            for(int i : count) {
                res = res * 31 + i;
                res %= base;
            }
            return res;
        }

    }
}
