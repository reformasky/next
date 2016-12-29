package org.xuan.array;

/**
 * Created by xzhou2 on 12/27/16.
 */
public class FindMin_153 {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int low = 0, high = nums.length - 1;
        if (nums[low] < nums[high]) {
            return nums[low];
        }
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                break;
            }
        }
        return Math.min(nums[low], nums[high]);
    }
}
