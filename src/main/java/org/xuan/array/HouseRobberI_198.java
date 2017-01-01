package org.xuan.array;

/**
 * Created by xzhou2 on 12/30/16.
 */
public class HouseRobberI_198 {
    public int rob(int[] nums) {
        int take = 0, nonTake = 0;
        for(int n : nums) {
            int tmp = take;
            take = Math.max(take, nonTake + n);
            nonTake = tmp;
        }
        return take;
    }
}
