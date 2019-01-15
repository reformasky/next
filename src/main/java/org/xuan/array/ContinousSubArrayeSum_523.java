package org.xuan.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 4/2/17.
 */
public class ContinousSubArrayeSum_523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            if (map.containsKey(sum)) {
                int pre = map.get(sum);
                if (i - pre > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
