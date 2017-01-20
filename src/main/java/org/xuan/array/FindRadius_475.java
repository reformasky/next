package org.xuan.array;

import java.util.Arrays;

/**
 * Created by xzhou2 on 1/9/17.
 */
public class FindRadius_475 {
    public int findRadius(int[] houses, int[] heaters) {
        if (houses.length == 0) {
            return 0;
        }
        Arrays.sort(heaters);
        int result = 0;
        for(int h : houses) {
            int r = Arrays.binarySearch(heaters, h);
            if (r >= 0) {
                continue;
            } else {
                int i = -1 -r;
                if (i > 0 && i < heaters.length) {
                    result = Math.max(Math.min(heaters[i] - h, h - heaters[i - 1]), result);
                } else if (i == 0){
                    result = Math.max(heaters[0] - h,result);
                } else {
                    result = Math.max(h - heaters[i - 1], result);
                }
            }
        }
        return result;
    }
}
