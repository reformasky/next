package org.xuan.array;

/**
 * Created by xzhou2 on 12/27/16.
 */
public class FindPeakElement_162 {
    public int findPeakElement(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }
}
