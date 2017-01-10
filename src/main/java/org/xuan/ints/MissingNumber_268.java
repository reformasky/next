package org.xuan.ints;

/**
 * Created by xzhou2 on 1/8/17.
 */
public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        for(int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            while(curr != nums.length && curr != nums[curr]) {
                int tmp = nums[curr];
                nums[curr] = curr;
                curr = tmp;
            }

        }
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}
