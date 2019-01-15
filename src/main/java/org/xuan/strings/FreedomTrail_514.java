package org.xuan.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 4/3/17.
 */
public class FreedomTrail_514 {
    public int findRotateSteps(String ring, String key) {
        if (key.length() == 0) {
            return 0;
        }
        List<Integer>[] indexes = (List<Integer>[]) new List[26];
        for(int i = 0; i < 26; i++) {
            indexes[i] = new ArrayList<>();
        }
        for(int i = 0; i < ring.length(); i++) {
            indexes[ring.charAt(i) - 'a'].add(i);
        }
        int[] cache = new int[ring.length()];
        int len = cache.length;
        for(int i : indexes[key.charAt(0) - 'a']) {
            cache[i] = Math.min(i, len - i);
        }
        for(int j = 1; j < key.length(); j++) {
            int[] copy = new int[ring.length()];
            Arrays.fill(copy, Integer.MAX_VALUE);
            List<Integer> curr = indexes[key.charAt(j) - 'a'], pre = indexes[key.charAt(j - 1) - 'a'];
            for(int p : pre) {
                for(int c : curr) {
                    int abs = Math.abs(p - c);
                    int tmp = cache[p] + Math.min(abs, len - abs);
                    copy[c] = Math.min(tmp, copy[c]);
                }
            }
            cache = copy;
        }
        int min = Integer.MAX_VALUE;
        for(int i : cache) {
            min = Math.min(min, i);
        }
        return min + key.length();
    }
}
