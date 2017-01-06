package org.xuan.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xzhou2 on 1/2/17.
 */
public class ContainsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }
}
