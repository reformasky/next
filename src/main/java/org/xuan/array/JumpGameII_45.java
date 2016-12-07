package org.xuan.array;

/**
 * Created by xzhou2 on 12/1/16.
 */
public class JumpGameII_45 {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int res = 1, pre = 0, max = nums[0];
        while(max < nums.length - 1) {
            int tmpMax = max;
            for(int i = pre + 1; i <= max; i++){
                tmpMax = Math.max(i + nums[i], tmpMax);
            }
            pre = max;
            max = tmpMax;
            res++;
        }
        return res;
    }
}
