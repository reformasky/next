package org.xuan.array;

/**
 * Created by xzhou2 on 11/28/16.
 */
public class SearchInRange_35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]){
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }




    public int searchInsert_recursion(int[] nums, int target) {
        return searchInsert_recursion(nums, 0, nums.length - 1, target);
    }

    private int searchInsert_recursion(int[] nums, int low, int high, int target) {
        if (low > high) {
            return low;
        }
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return searchInsert_recursion(nums, low, mid - 1, target);
        }  else {
            return searchInsert_recursion(nums, mid + 1, high, target);
        }
    }
}
