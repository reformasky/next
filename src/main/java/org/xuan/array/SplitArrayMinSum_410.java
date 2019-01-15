package org.xuan.array;

/**
 * Created by xzhou2 on 2/20/17.
 */
public class SplitArrayMinSum_410 {
    public int splitArray(int[] nums, int m) {
        long max = 0, sum = 0;
        for(int n : nums) {
            max = Math.max(max, n);
            sum += n;
        }
        return binarySearch(nums, max, sum, m);
    }

    private int binarySearch(int[] nums, long low, long high, int m) {
        while(low < high) {
            long mid = (high + low) / 2;
            if (isValid(nums, mid, m)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return (int)high;
    }
    //can not have a split that has >= m sub array with > target sum.
    private boolean isValid(int[] nums, long target, int m) {
        long sum = 0;
        int count = 0;
        for(int n : nums) {
            sum += n;
            if (sum > target) {
                sum = n;
                if (++count == m) {
                    return false;
                }
            }
        }
        return true;
    }
    public int splitArrayDP(int[] nums, int m) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        for(int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] + nums[i];
        }
        for(int k = 2; k <= m; k++) {
            for(int i = m - k; i <= n - k; i++) {
                dp[i] = Integer.MAX_VALUE;
                for(int j = i, sum = 0; j <= n - k; j++) {
                    sum += nums[j];
                    if (sum >= dp[i]) {
                        break;
                    }
                    dp[i] = Math.max(sum, dp[j + 1]);
                }
                if (k == m) {
                    break;
                }
            }
        }

        return dp[0];
    }
}
