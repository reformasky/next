package org.xuan.array;

/**
 * Created by xzhou2 on 2/27/17.
 */
public class MinMoves_453 {
    /**
     * Proof:
     * a0 = min(nums);
     * suppose in the end, every ele is x; then we have
     * (x - a0) + (x - a1) + ... + (x - an) = (n - 1) (x - a0);
     * x = a0 +... + an - (n - 1) * a0;
     * min steps = x - a0 = sum - n * a0;
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int n : nums) {
            min = Math.min(min, n);
        }
        int result = 0;
        for(int n : nums) {
            result += (n - min);
        }
        return result;
    }
}
