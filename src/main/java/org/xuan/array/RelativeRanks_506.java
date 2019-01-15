package org.xuan.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xzhou2 on 3/29/17.
 */
public class RelativeRanks_506 {
    private static final String[] medals = {"Gold Medal", "Silver Medal","Bronze Medal"};
    public String[] findRelativeRanks(int[] nums) {
        if (nums.length == 0) {
            return new String[0];
        }
        int[][] cp = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++) {
            cp[i] = new int[]{nums[i], i};
        }
        Arrays.sort(cp, (a, b) -> -a[0] + b[0]);
        String[] res = new String[nums.length];
        for(int i = 0; i < res.length; i++) {
            res[cp[i][1]] = i > 2 ? "" + (i + 1) : medals[i];
        }
        return res;
    }
}
