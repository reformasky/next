package org.xuan.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xzhou2 on 1/3/17.
 */
public class ContainsDuplicateII_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        k++;
        for(int i = 0; i < nums.length; i++) {
            if (i >= k) {
                set.remove(nums[i - k]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
