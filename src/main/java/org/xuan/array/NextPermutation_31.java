package org.xuan.array;

import java.util.Arrays;

/**
 * Created by xzhou2 on 11/27/16.
 */
public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int i = nums.length - 2;
        for(; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                for(int j = nums.length - 1; j > i; j--){
                    if (nums[j] > nums[i]) {
                        int tmp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = tmp;
                        break;
                    }
                }
                break;
            }
        }
        for(int j = i + 1, k = nums.length - 1; j < k; j++, k--) {
            int tmp = nums[j];
            nums[j] = nums[k];
            nums[k] = tmp;
        }
    }

}
