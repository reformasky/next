package org.xuan.array;

import java.util.LinkedList;

/**
 * Created by xzhou2 on 1/8/17.
 */
public class MaxSlidingWindow_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k <= 1) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        LinkedList<int[]> list = new LinkedList<>();
        for(int i = 0; i < k; i++) {
            int[] next = new int[]{nums[i], i};
            while(!list.isEmpty() && list.getLast()[0] <= nums[i]) {
                list.pollLast();
            }
            list.offerLast(next);
            result[0] = list.getFirst()[0];
        }
        for(int i = k; i < nums.length; i++) {
            int[] next = new int[]{nums[i], i};
            while(!list.isEmpty() && list.getFirst()[1]<= (i - k)) {
                list.pollFirst();
            }
            while(!list.isEmpty() && list.getLast()[0] <= nums[i]) {
                list.pollLast();
            }
            list.offerLast(next);
            result[i - k + 1] = list.getFirst()[0];
        }
        return result;
    }
}
