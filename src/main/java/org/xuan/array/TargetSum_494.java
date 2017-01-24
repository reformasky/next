package org.xuan.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 1/21/17.
 */
public class TargetSum_494 {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> counts = new HashMap<>(), curr;
        if (nums[0] == 0) {
            counts.put(0, 2);
        } else {
            counts.put(nums[0], 1);
            counts.put(-nums[0], 1);
        }
        for(int i = 1; i < nums.length; i++) {
            curr = new HashMap<>();
            for(Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                int val1 = entry.getKey() + nums[i], val2 = entry.getKey() - nums[i];
                if (curr.containsKey(val1)) {
                    curr.put(val1, curr.get(val1) + entry.getValue());
                } else {
                    curr.put(val1, entry.getValue());
                }
                if (curr.containsKey(val2)) {
                    curr.put(val2, curr.get(val2) + entry.getValue());
                } else {
                    curr.put(val2, entry.getValue());
                }
            }

            counts = curr;
        }
        return counts.containsKey(S) ? counts.get(S) : 0;
    }

    public int findTargetSumWays_1(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }
        if (S > sum || S < -sum) {
            return 0;
        }
        int[] cache = new int[2 * sum + 1], curr;
        cache[sum] = 1;
        for(int n : nums) {
            curr = new int[2 * sum + 1];
            for(int i = 0; i < cache.length; i++) {
                if (i - n >= 0) {
                    curr[i] += cache[i - n];
                }
                if (i + n < cache.length) {
                    curr[i] += cache[i + n];
                }
            }
            cache = curr;
        }
        return cache[S + sum];
    }
}
