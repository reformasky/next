package org.xuan.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xzhou2 on 2/27/17.
 */
public class MinArrowBurstBloom_452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int result = 1;
        int end = points[0][1];
        for(int i = 1; i < points.length; i++) {
            if (end < points[i][0]) {
                result++;
                end = points[i][1];
            } else {
                end = Math.min(end, points[i][1]);
            }
        }
        return result;
    }
}
