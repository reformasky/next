package org.xuan.array;

/**
 * Created by xzhou2 on 1/2/17.
 */
public class FindKthLargest_215 {
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, k);
    }

    private int helper(int[] nums, int low, int high, int k) {
        if (low == high) {
            return nums[low];
        }
        int val = nums[low];
        int left = low, right = high + 1;
        while(true) {
            while(left < high && nums[++left] < val) ;
            while(right > low  && nums[--right]  > val);
            if (left >= right) {
                break;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }

        nums[low] = nums[right];
        nums[right] = val;
        if (right == nums.length - k) {
            return val;
        } else if (right > nums.length - k) {
            return helper(nums, low, right - 1, k);
        } else {
            return helper(nums, right + 1, high, k);
        }
    }
}
