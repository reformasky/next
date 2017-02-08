package org.xuan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 1/24/17.
 */
public class LargestDivisibleSubset_368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] pre = new int[nums.length], count = new int[nums.length];
        int size = 0, last = -1;
        for(int i = 0; i < nums.length; i++) {
            pre[i] = i;
            count[i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 &&  count[i] < 1 + count[j]) {
                    count[i] = 1 + count[j];
                    pre[i] = j;
                }
            }
            if (count[i] > size) {
                size = count[i];
                last = i;
            }
        }
        List<Integer> result = new ArrayList<>(size);
        while(result.size() < size) {
            result.add(nums[last]);
            last = pre[last];
        }
        return result;
    }
}
