package org.xuan.array;

/**
 * Created by xzhou2 on 12/5/16.
 */
public class JumpGameI_55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int preMax = 0, max = nums[0];
        while(max < nums.length - 1) {
            int tmp = max;
            for(int i = preMax + 1; i <= tmp; i++) {
                max = Math.max(i + nums[i], max);
            }
            if (max == tmp) {
                return false;
            }
            preMax = tmp;

        }
        return true;
    }
}
