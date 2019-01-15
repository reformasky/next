package org.xuan.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
                Integer left = map.getOrDefault(num - 1, 0),
                        right = map.getOrDefault(num + 1, 0);
                int curr = 1;
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
