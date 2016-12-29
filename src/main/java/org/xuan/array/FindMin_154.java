package org.xuan.array;

/**
 * Created by xzhou2 on 12/27/16.
 */
public class FindMin_154 {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int low = 0, high = nums.length - 1;
        if (nums[low] < nums[high]) {
            return nums[0];
        }
        while(low <= high) {
            //System.out.println(low + " " + high);

            int mid = low + (high - low) / 2,
                    curr = nums[mid];
            if (curr < nums[high] || ( curr == nums[high] && curr < nums[low])) {
                high = mid;
            } else if (curr > nums[high]) {
                low = mid + 1;
            } else {
                high--;
            }
        }
        return high >= 0 ? Math.min(nums[high], nums[low]) : nums[low];
    }
}
