package org.xuan.array;

import java.util.Arrays;

/**
 * Created by xzhou2 on 1/10/17.
 */
public class LengthOfLongestIncreasingSubseqence_300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] cache = new int[nums.length];
        int index = 0;
        for(int n : nums) {
            if (index == 0) {
                cache[index++] = n;
            } else {
                int r = Arrays.binarySearch(cache, 0, index, n);
                if (r < 0) {
                    int insertPoint = -1 - r;
                    cache[insertPoint] = n;
                    //System.out.println(insertPoint);
                    if (insertPoint == index) {
                        index++;
                    }
                }
            }
        }
        return index;
    }
}
