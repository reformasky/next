package org.xuan.array;

import java.util.Arrays;

/**
 * Created by xzhou2 on 11/28/16.
 */
public class SearchRange_34 {
    public int[] searchRange(int[] nums, int target) {
        return searchRange(nums, 0, nums.length - 1, target);
    }

    private int[] searchRange(int[] nums, int low, int high, int target) {
        if (low > high) {
            return new int[]{-1, -1};
        }
        if (low == high) {
            return nums[low] == target ? new int[]{low, low} : new int[]{-1, -1};
        }
        int res = Arrays.binarySearch(nums, low, high + 1, target), first = res, second = res;
        if (res >= 0) {
            int[] left = searchRange(nums, low, res - 1, target), right = searchRange(nums, res + 1, high, target);
            if(left[0] != -1) {
                first = left[0];
            }
            if (right[1] != -1) {
                second = right[1];
            }
            return new int[]{first, second};
        } else {
            return new int[]{-1, -1};
        }
    }
}
