package org.xuan.array;

import java.util.Arrays;

/**
 * Created by xzhou2 on 12/28/16.
 */
public class MaxGap_164 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int num : nums) {
            max = num > max ? num : max;
            min = num < min ? num : min;
        }
        if (max == min) {
            return 0;
        }
        int bucketSize = (max - min) / nums.length + 1;
        int[] mins = new int[(max - min)/bucketSize + 1],
                maxs = new int[(max - min)/bucketSize + 1];
        Arrays.fill(mins, max);
        Arrays.fill(maxs, min);
        for(int num : nums) {
            int index = (num - min) / bucketSize;
            mins[index] = Math.min(mins[index], num);
            maxs[index] = Math.max(maxs[index], num);
        }
        int result = 0;
        max = Integer.MIN_VALUE;

        for(int i = 0; i < maxs.length; i++) {
            if (mins[i] <= maxs[i]) {
                if (max > 0) {
                    result = Math.max(mins[i] - max, result);
                }
                max = maxs[i];
            }
        }
        return result;
    }
}
