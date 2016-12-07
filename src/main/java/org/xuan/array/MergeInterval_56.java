package org.xuan.array;

import org.xuan.util.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xzhou2 on 12/5/16.
 */
public class MergeInterval_56 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        if (intervals.size() == 0) {
            return result;
        }
        Interval curr = new Interval(intervals.get(0).start, intervals.get(0).end);
        for(int i = 1; i < intervals.size(); i++) {
            Interval tmp = intervals.get(i);
            if (tmp.start > curr.end) {
                result.add(curr);
                curr = new Interval(tmp.start, tmp.end);
            } else {
                curr.end = Math.max(tmp.end, curr.end);
            }
        }
        result.add(curr);
        return result;
    }
}
