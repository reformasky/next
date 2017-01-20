package org.xuan.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * Created by xzhou2 on 1/17/17.
 */
public class CreateMaxNumber_321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        Arrays.fill(result, 0);
        for(int i = Math.max(0, k - nums2.length); i <= Math.min(nums1.length, k); i++) {
            int j = k - i;
            int[] left = getMaxSubArray(nums1, i), right = getMaxSubArray(nums2, j);
            int[] curr = merge(left, right);
            if (compare(curr, 0, result, 0) > 0) {
                result = curr;
            }
        }

        return result;
    }

    private int[] merge(int[] left, int[] right) {
        int i1 = 0, i2 = 0, i = 0;
        int[] result = new int[left.length + right.length];
        while (i1 < left.length && i2 < right.length) {
            if (compare(left, i1, right, i2) > 0) {
                result[i++] = left[i1++];
            } else {
                result[i++] = right[i2++];
            }
        }
        while (i1 < left.length) {
            result[i++] = left[i1++];
        }
        while (i2 < right.length) {
            result[i++] = right[i2++];
        }

        return result;
    }

    private int[] getMaxSubArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; ++i) {
            while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
            if (j < k) ans[j++] = nums[i];
        }
        return ans;
    }

    private int compare(int[] lhs, int i, int[] rhs, int j) {
        while(i < lhs.length && j < rhs.length) {
            if (lhs[i] > rhs[j]) {
                return 1;
            } else if (lhs[i] < rhs[j]) {
                return -1;
            }
            i++;
            j++;
        }
        return i == lhs.length ? -1 : j == rhs.length ? 1 :0;
    }
}
