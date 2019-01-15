package org.xuan.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xzhou2 on 3/7/17.
 */
public class KDiffPairs_532 {
    public int findPairs(int[] nums, int k) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        if (k < 0) {
            return 0;
        }
        Set<Integer> dup = new HashSet<>();
        for(int i : nums) {
            if (!set.add(i)) {
                dup.add(i);
            }
        }
        if (k == 0) {
            return dup.size();
        }
        for(int i : set) {
            if (set.contains(i + k)) {
                result++;
            }
        }
        return result;
    }
}
