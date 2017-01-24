package org.xuan.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xzhou2 on 1/22/17.
 */
public class IntersectionOfTwoArrays_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>(),
                set1 = new HashSet<>();
        for(int num : nums1) {
            set1.add(num);
        }
        for(int num : nums2) {
            if (set1.remove(num)) {
                result.add(num);
            }
        }
        int[] res = new int[result.size()];
        int index = 0;
        for(int i : result) {
            res[index++] = i;
        }
        return res;
    }
}
