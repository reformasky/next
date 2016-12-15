package org.xuan.array;

/**
 * Created by xzhou2 on 12/14/16.
 */
public class MergeSort_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m + n - 1; i >= n; i--) {
            nums1[i] = nums1[i - n];
        }
        int low1 = n, low2 = 0, curr = 0;
        while(low1 < m + n && low2 < n) {
            if (nums1[low1] <= nums2[low2]) {
                nums1[curr++] = nums1[low1++];
            } else {
                nums1[curr++] = nums2[low2++];
            }
        }
        while(low2 < n) {
            nums1[curr++] = nums2[low2++];
        }
    }
}
