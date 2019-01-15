package org.xuan.ints;

/**
 * Created by xzhou2 on 2/26/17.
 */
public class LexiOrderII_440 {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while(k > 0) {
            int steps = calSteps(curr, curr + 1, n);
            if (steps <= k) {
                k -= steps;
                curr ++;
            } else {
                k--;
                curr *= 10;
            }

        }
        return curr;
    }

    private int calSteps(long n1, long n2, int n) {
        int steps = 0;
        while(n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }
}
