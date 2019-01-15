package org.xuan.array;

/**
 * Created by xzhou2 on 3/6/17.
 */
public class MaxConstitutiveOne_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int begin = 0, result = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                result = Math.max(result, i - begin);
                begin = i + 1;
            }
        }
        result = Math.max(result, nums.length - begin);
        return result;
    }
}
