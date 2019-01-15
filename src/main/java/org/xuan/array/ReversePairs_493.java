package org.xuan.array;

/**
 * Created by xzhou2 on 3/8/17.
 */
public class ReversePairs_493 {
    public int reversePairs(int[] nums) {
        int[] tmp = new int[nums.length];
        return count(nums, 0, nums.length - 1, tmp);
    }

    private int count(int[] nums, int low, int high, int[] tmp) {
        if (low >= high) {
            return 0;
        }
        int mid = (high + low ) / 2;
        int left = count(nums, low, mid, tmp);
        int right = count(nums, mid + 1, high, tmp);
        int curr = 0;
        int l = low, h = mid + 1;
        while(l <= mid && h <= high) {
            if (nums[l] >  2l * nums[h]) {
                curr += (mid - l + 1);
                h++;
            } else {
                l++;
            }
        }
        merge(nums, low, mid, high, tmp);
        return left + right + curr;
    }

    private void merge(int[] nums, int low, int mid, int high, int[] tmp) {
        for(int i = low; i <= high; i++) {
            tmp[i] = nums[i];
        }
        int l = low, h = mid + 1, i = low;
        while(l <= mid && h <= high) {
            if (tmp[l] <= tmp[h]) {
                nums[i++] = tmp[l++];
            } else {
                nums[i++] = tmp[h++];
            }
        }
        while(l <= mid) {
            nums[i++] = tmp[l++];
        }
        while(h <= high) {
            nums[i++] = tmp[h++];
        }

    }
}
