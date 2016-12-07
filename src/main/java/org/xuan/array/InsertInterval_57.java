package org.xuan.array;

import org.xuan.util.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 12/5/16.
 */
public class InsertInterval_57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        boolean end = false;
        Interval curr = new Interval(newInterval.start, newInterval.end);
        for(Interval tmp : intervals) {
            if (end) {
                result.add(tmp);
            } else {
                if (curr.end < tmp.start) {
                    end = true;
                    result.add(curr);
                    result.add(tmp);
                } else if (curr.start > tmp.end) {
                    result.add(tmp);
                } else {
                    curr.start = Math.min(tmp.start, curr.start);
                    if (curr.end <= tmp.end){
                        curr.end = tmp.end;
                        result.add(curr);
                        end = true;
                    }
                }
            }
        }
        if (!end) {
            result.add(curr);
        }
        return result;
    }
}
