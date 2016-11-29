package org.xuan.array;

/**
 * Created by xzhou2 on 11/28/16.
 */
public class SearchInRotateArrayNoDup_33 {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        if (low == high) {
            return nums[low] == target ? low : -1;
        }
        int mid = low + (high - low) /2;
        if (target == nums[mid]) {
            return mid;
        }
        //left is sorted
        if (nums[mid] >= nums[low]) {
            if (target > nums[mid] || target < nums[low]) {
                return search(nums, mid + 1, high, target);
            } else {
                return search(nums, low, mid - 1, target);
            }
        } else {
            if (target < nums[mid] || target >= nums[low]) {
                return search(nums, low, mid - 1, target);
            } else {
                return search(nums, mid + 1, high, target);
            }
        }
    }
}
