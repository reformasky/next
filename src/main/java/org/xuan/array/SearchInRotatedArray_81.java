package org.xuan.array;

import java.util.Arrays;

/**
 * Created by xzhou2 on 12/13/16.
 */
public class SearchInRotatedArray_81 {
    public boolean search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private boolean search(int[] nums, int low, int high, int target) {
        if (low > high) {
            return false;
        }
        int mid = low + (high - low) / 2;
        if (target == nums[mid]) {
            return true;
        }
        if (nums[mid] > nums[low]) {
            //[low, mid] is sorted;
            if (target >= nums[low] && target < nums[mid]) {
                return Arrays.binarySearch(nums, low, mid, target) >= 0;
            } else {
                return search(nums, mid + 1, high, target);
            }
        } else if (nums[mid] < nums[low]) {
            //[mid, high] is sorted
            if (target > nums[mid] && target <= nums[high]) {
                return Arrays.binarySearch(nums, mid + 1, high + 1, target) >= 0;
            } else {
                return search(nums, low, mid - 1, target);
            }
        } else {
            if (nums[mid] == nums[high]) {
                return search(nums, low, high - 1, target);
            } else if (nums[mid] > nums[high]) {
                return target > nums[mid] ? false : search(nums, mid + 1, high, target);
            } else {
                return Arrays.binarySearch(nums, mid + 1, high + 1, target) >= 0;
            }
        }
    }
}
