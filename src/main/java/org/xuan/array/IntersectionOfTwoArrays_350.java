package org.xuan.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xzhou2 on 1/22/17.
 */
public class IntersectionOfTwoArrays_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> cache = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums1) {
            if (!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }
        for(int n : nums2) {
            if (map.containsKey(n)) {
                cache.add(n);
                int count = map.get(n);
                if (count == 1) {
                    map.remove(n);
                } else {
                    map.put(n, count - 1);
                }
            }
        }
        int[] result = new int[cache.size()];
        for(int i = 0; i < result.length; i++)  {
            result[i] = cache.get(i);
        }
        return result;
    }
}
