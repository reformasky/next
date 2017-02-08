package org.xuan.array;

import java.util.Arrays;

/**
 * Created by xzhou2 on 1/26/17.
 */
public class CombinationSumIV_377 {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] cache = new int[target + 1];
        cache[0] = 1;
        for(int i = 1; i <= target; i++) {
            int curr = 0;
            for(int n : nums) {
                if (n > i) {
                    break;
                }
                curr += cache[i - n];
            }
            cache[i] = curr;
        }
        return cache[target];
    }

}
