package org.xuan.array;

import java.util.Arrays;

/**
 * Created by xzhou2 on 11/17/16.
 */
public class ThreeSumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE, diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    if (sum - target < diff) {
                        result = sum;
                        diff = sum - target;
                    }
                    right--;
                } else {
                    if (target - sum < diff) {
                        result = sum;
                        diff = target - sum;
                    }
                    left++;
                }
            }
        }
        return result;
    }
}
