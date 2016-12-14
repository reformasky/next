package org.xuan.array;

/**
 * Created by xzhou2 on 12/12/16.
 */
public class RemoveDuplicateII_80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int index = 1;
        boolean same = false;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
                same = false;
            } else if (!same) {
                same = true;
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
