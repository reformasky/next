package org.xuan.array;

/**
 * Created by xzhou2 on 11/14/16.
 */
public class MedianOfTwoSortedArrays_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length, len = len1 + len2;
        if (len % 2 == 0) {
            return 0.5 * findKth(nums1, 0, len1, nums2, 0, len2,  len / 2) + 0.5 * findKth(nums1, 0, len1, nums2, 0, len2,  len / 2 + 1);
        } else {
            return findKth(nums1, 0, len1, nums2, 0, len2, len / 2 + 1);
        }
    }

    public int findKth(int[] nums1, int low1, int len1, int[] nums2, int low2, int len2, int k) {
        if (len1 > len2) {
            return findKth(nums2, low2, len2, nums1, low1, len1, k);
        }
        if (len1 == 0) {
            return nums2[low2 +  k  - 1];
        }
        if (k == 1) {
            return Math.min(nums1[low1], nums2[low2]);
        }
        int pa = Math.min(len1, k / 2), pb = k - pa;
        if (nums1[low1 + pa - 1] == nums2[low2 + pb - 1]) {
            return nums1[low1 + pa - 1];
        } else if (nums1[low1 + pa - 1] > nums2[low2 + pb - 1]) {
            return findKth(nums1, low1, len1, nums2, low2 + pb, len2 - pb, k - pb);
        } else {
            return findKth(nums1, low1 + pa, len1 - pa, nums2, low2, len2, k - pa);
        }
    }


}
