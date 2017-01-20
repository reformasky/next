package org.xuan.array;

/**
 * Created by xzhou2 on 1/20/17.
 */
public class IncreasingTriplet_334 {
    public boolean increasingTriplet(int[] nums) {
        long first = Integer.MAX_VALUE + 1l, second = Integer.MAX_VALUE + 1l;
        for(int n : nums) {
            if (n > second) {
                return true;
            } else if (n > first) {
                second = Math.min(second, n);
            }
            first = Math.min(first, n);
        }
        return false;
    }
}
