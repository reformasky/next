package org.xuan.array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by xzhou2 on 1/3/17.
 */
public class ContainsDuplicate_220 {
    public boolean containsNearbyAlmostDuplicate_bucket(int[] nums, int k, int t) {
        if (k == 0 || nums.length < 2 || t < 0) {
            return false;
        }
        Map<Long, Long> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            long bucket = (nums[i] - (long)Integer.MIN_VALUE)/( (long)t + 1);
            if (map.containsKey(bucket)
                    ||(map.containsKey(bucket - 1) && nums[i] - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - nums[i] <= t)) {
                return true;
            }
            map.put(bucket, (long)nums[i]);
            if (i >= k) {
                long toBeDeleted = (nums[i - k] - (long)Integer.MIN_VALUE)/ ((long)t + 1);
                map.remove(toBeDeleted);
            }
        }
        return false;
    }


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 0 || nums.length < 2) {
            return false;
        }
        k++;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            if (i >= k) {
                set.remove(nums[i - k]);
            }
            int low = nums[i] - t;
            Integer ceiling = set.ceiling(low);
            if (ceiling != null && (ceiling < nums[i] || ceiling - nums[i] <= t)) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
