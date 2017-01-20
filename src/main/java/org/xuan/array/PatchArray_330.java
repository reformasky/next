package org.xuan.array;

/**
 * Created by xzhou2 on 1/19/17.
 */
public class PatchArray_330 {
    public int minPatches(int[] nums, int n) {
        long sum = 0;
        int index = 0, result = 0;
        while(sum < n) {
            if (index >= nums.length|| sum < nums[index] - 1) {
                sum += (sum + 1);
                result++;
            } else {
                sum += nums[index++];
            }
        }
        return result;
    }
}
