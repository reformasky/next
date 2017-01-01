package org.xuan.ints;

/**
 * Created by xzhou2 on 1/1/17.
 */
public class TotalHammingDistance_477 {
    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int j=0;j<32;j++) {
            int bitCount = 0;
            for (int num : nums)
                bitCount += (num >> j) & 1;
            total += bitCount*(n - bitCount);
        }
        return total;
    }
}
