package org.xuan.ints;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xzhou2 on 12/30/16.
 */
public class HappyNumber_202 {
    public class Solution {
        public boolean isHappy(int n) {
            Set<Integer> hasSeen = new HashSet<>();
            hasSeen.add(n);
            while(true) {
                int next = next(n);
                if (next == 1) {
                    return true;
                } else if (!hasSeen.add(next)) {
                    return false;
                }
                n = next;
            }
        }

        private int next(int n) {
            return 0;
        }
    }
}
