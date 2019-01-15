package org.xuan.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xzhou2 on 2/20/17.
 */
public class MaxXOR_421 {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int n : nums) {
                set.add(n & mask);
            }
            int tmp = max | (1 << i);
            for(int preFix : set) {
                if (set.contains(preFix ^ tmp)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

}
