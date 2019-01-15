package org.xuan.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 2/23/17.
 */
public class ContinuousArray_525 {
    public int findMaxLength(int[] nums) {
        int sum = 0, result = 0;
        Map<Integer, Integer> prefix = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if (sum == 0) {
                result = i + 1;
            } else if (prefix.containsKey(sum)){
                result = Math.max(i - prefix.get(sum), result);
            } else {
                prefix.put(sum, i);
            }
        }
        return result;
    }
}
