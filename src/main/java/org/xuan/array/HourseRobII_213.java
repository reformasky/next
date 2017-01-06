package org.xuan.array;

/**
 * Created by xzhou2 on 1/2/17.
 */
public class HourseRobII_213 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int low, int high) {
        int taken = nums[low] , noTaken = 0;
        for(int i = low + 1; i <= high; i++) {
            int tmp = taken;
            taken = Math.max(noTaken + nums[i], taken);
            noTaken = tmp;
        }
        return taken;
    }
}
