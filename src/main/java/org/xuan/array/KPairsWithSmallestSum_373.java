package org.xuan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xzhou2 on 1/25/17.
 */
public class KPairsWithSmallestSum_373 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 > len2) {
            return kSmallestPairs(nums2, nums1, k, true);
        } else {
            return kSmallestPairs(nums1, nums2, k, false);
        }

    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k, boolean reverse) {
        int len1 = nums1.length, len2 = nums2.length;

        k = Math.min(k, len1 * len2);
        List<int[]> result = new ArrayList<>(k);
        if (k == 0) {
            return result;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] indexes = new int[len1];
        //sum; index
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        }) ;
        for(int i = 0; i < len1; i++) {
            queue.offer(new int[]{nums1[i] + nums2[indexes[i]++], i});
        }
        while(result.size() < k) {
            int[] pair = queue.poll();
            int[] curr = reverse ? new int[] {nums2[indexes[pair[1]]-1], nums1[pair[1]]} :
                    new int[] {nums1[pair[1]],nums2[indexes[pair[1]]-1]};
            result.add(curr);
            if (indexes[pair[1]] < len2 ) {
                queue.offer(new int[]{nums1[pair[1]] + nums2[indexes[pair[1]]++], pair[1]});
            }
        }
        return result;
    }
}
