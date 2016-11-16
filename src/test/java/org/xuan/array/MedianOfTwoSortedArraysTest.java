package org.xuan.array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by xzhou2 on 11/14/16.
 */
public class MedianOfTwoSortedArraysTest {
    MedianOfTwoSortedArrays_4 obj = new MedianOfTwoSortedArrays_4();
    long time = System.currentTimeMillis();
    Random random = new Random(time);
    @Test
    public void test() {
        int n = 100;
        int l1 = random.nextInt(n), l2 = n - l1;
        int[] nums1 = new int[l1], nums2 = new int[l2], nums = new int[n];
        for(int i = 0, i1 = 0, i2 = 0; i < n; i++ ) {
            int num = random.nextInt(n * 3);
            if (i1 < l1) {
                nums1[i1++] = num;
            } else{
                nums2[i2++] = num;
            }
            nums[i] = num;
        }
        Arrays.sort(nums);
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for(int i = 2; i <= n; i++) {
            try {
                int res = obj.findKth(nums1,0, nums1.length, nums2,0, nums2.length, i);
                Assert.assertEquals(res, nums[i - 1]);
            } catch (Throwable ex) {
                System.out.println(ex.getMessage());
                System.out.println(time);
                System.out.println(i);
                Assert.fail(ex.getMessage());
                break;
            }

        }

    }
}
