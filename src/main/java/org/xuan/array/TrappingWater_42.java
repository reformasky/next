package org.xuan.array;

/**
 * Created by xzhou2 on 11/30/16.
 */
public class TrappingWater_42 {
    public int trap(int[] height) {
        int threshold = 0, left = 0, right = height.length - 1, result = 0;
        while(left < right) {
            int min = Math.min(height[left], height[right]);
            threshold = Math.max(threshold, min);
            result += threshold - min;
            if (min == height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
