package org.xuan.array;

/**
 * Created by xzhou2 on 1/18/17.
 */
public class CountRangeSum_327 {
    int result = 0;
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length];
        for(int i = 0; i < sums.length; i++) {
            sums[i] = nums[i];
            if (i > 0) {
                sums[i] += sums[i - 1];
            }
        }
        helper(sums, 0, sums.length - 1, lower, upper, new long[sums.length]);
        return result;
    }

    private void helper(long[] sums, int low, int high, int lower, int upper, long[] copy) {
        if (low == high) {
            if (sums[low] >= lower && sums[low] <= upper) {
                result++;
            }
        } else if(low < high) {
            int mid = low + (high - low)/2;
            helper(sums, low, mid, lower, upper, copy);
            helper(sums, mid + 1, high, lower, upper, copy);
            int i = mid + 1, j = mid + 1;
            for(int k = low; k <= mid; k++) {
                while(j <= high && sums[j] - sums[k] <= upper) j++;
                while(i <= high && sums[i] - sums[k] < lower) i++;
                result += (j - i);
            }
            merge(sums, low, mid, high, copy);
        }

    }

    private void merge(long[] sums, int low, int mid, int high, long[] copy) {
        System.arraycopy(sums, low, copy, low, high + 1 - low);
        int left = low, right = mid + 1, index = low;
        while(left <= mid && right <= high) {
            if (copy[left] < copy[right]) {
                sums[index++] = copy[left++];
            } else {
                sums[index++] = copy[right++];
            }
        }
        while(left <= mid) {
            sums[index++] = copy[left++];
        }
        while(right <= high) {
            sums[index++] = copy[right++];
        }
    }
}
