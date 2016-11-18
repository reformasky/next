package org.xuan.array;

/**
 * Created by xzhou2 on 11/16/16.
 */
public class MaxArea_11 {
    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int maxLeft = 0, res = 0;
        for(int i = 0; i < height.length; i++) {
            if (height[i] > maxLeft) {
                maxLeft = height[i];
                int maxRight = 0;
                for(int j = height.length - 1; j > i; j--) {
                    if (height[j] >= maxLeft) {
                        res = Math.max(res, maxLeft * (j - i));
                        break;
                    }
                    if (height[j] > maxRight) {
                        maxRight = height[j];
                        res = Math.max(res, maxRight * (j - i));
                    }
                }
            }
        }
        return res;
    }
}
