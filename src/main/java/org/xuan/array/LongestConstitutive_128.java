package org.xuan.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xzhou2 on 12/17/16.
 */
public class LongestConstitutive_128 {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if (!map.containsKey(num)) {
                Integer left = map.get(num - 1),
                        right = map.get(num + 1);
                int curr = 1;
                left = left == null ? 0 : left;
                right = right == null ? 0 : right;
                curr += left + right;
                result = Math.max(result, curr);
                map.put(num, curr);
                map.put(num - left, curr);
                map.put(num + right, curr);
            }
        }
        return result;
    }
}
