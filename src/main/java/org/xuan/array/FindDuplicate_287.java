package org.xuan.array;

/**
 * Created by xzhou2 on 1/9/17.
 */
public class FindDuplicate_287 {
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for(int n : nums) {
                if (n <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;

    }
}
