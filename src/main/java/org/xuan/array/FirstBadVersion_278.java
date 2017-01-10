package org.xuan.array;

import java.util.Random;

/**
 * Created by xzhou2 on 1/8/17.
 */
public class FirstBadVersion_278 {
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while(low < high) {
            int mid = low + (high - low)/2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return isBadVersion(high) ? high : high + 1;
    }

    private boolean isBadVersion(int i) {
        return new Random().nextBoolean();
    }
}
