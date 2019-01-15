package org.xuan.array;

import org.xuan.util.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xzhou2 on 2/23/17.
 */
public class EraseOverlappingIntervals_435 {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length < 2) {
            return 0;
        }
        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);
        int count = 1, start = intervals[intervals.length - 1].start;
        for(int i = intervals.length - 2; i >= 0; i--) {
            if (intervals[i].end <= start) {
                start = intervals[i].start;
                count++;
            }
        }
        return intervals.length - count;
    }
}
