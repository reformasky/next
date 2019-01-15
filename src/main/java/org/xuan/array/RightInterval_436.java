package org.xuan.array;

import org.xuan.util.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xzhou2 on 2/23/17.
 */
public class RightInterval_436 {
    public int[] findRightInterval(Interval[] intervals) {
        if (intervals.length == 0) {
            return new int[0];
        } else if (intervals.length == 1) {
            return new int[]{-1};
        }
        int[][] mapper = new int[intervals.length][2];
        for(int i = 0; i < intervals.length; i++) {
            mapper[i] = new int[]{intervals[i].start, i};
        }
        Comparator<int[]> comparator = new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        };
        Arrays.sort(mapper, comparator);
        int[] result = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            int tmp = Arrays.binarySearch(mapper, new int[]{intervals[i].end}, comparator);
            tmp = tmp >= 0 ? tmp : -1 - tmp;
            result[i] = tmp < mapper.length ? mapper[tmp][1] : -1;
        }
        return result;
    }
}
