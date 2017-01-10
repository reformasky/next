package org.xuan.array;

/**
 * Created by xzhou2 on 1/8/17.
 */
public class MoveZeros_283 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int n : nums) {
            if (n != 0) {
                nums[index++] = n;
            }
        }
        for(int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
