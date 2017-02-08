package org.xuan.ints;

/**
 * Created by xzhou2 on 2/7/17.
 */
public class EliminationGame_390 {
    public int lastRemaining(int n) {
        int low = 1, high = n, diff = 1;
        boolean forward = true;
        while(low < high) {
            if (forward) {
                high -= (high - low) % (2 * diff) == 0 ? diff : 0;
                low += diff;
            } else {
                low += (high - low) % (2 * diff) == 0 ? diff : 0;
                high -= diff;
            }
            diff *= 2;
            forward = ! forward;
        }
        return low;
    }
}
