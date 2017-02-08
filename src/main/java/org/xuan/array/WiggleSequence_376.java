package org.xuan.array;

/**
 * Created by xzhou2 on 1/26/17.
 */
public class WiggleSequence_376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 1, result = 1;
        while(index <nums.length && nums[index] == nums[0]) {
            index++;
        }
        if (index == nums.length) {
            return result;
        }
        result++;
        boolean positive = nums[index] - nums[0] > 0 ;
        while(index < nums.length) {
            if ((!positive || (nums[index] < nums[index - 1])) &&
                    (positive || (nums[index] > nums[index - 1]))
                    ) {
                        result++;
                        positive = !positive;
                    }
            index++;
        }
        return result;
    }
}
