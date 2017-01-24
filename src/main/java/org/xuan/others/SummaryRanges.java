package org.xuan.others;

import org.xuan.util.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by xzhou2 on 1/23/17.
 */
public class SummaryRanges {
    TreeSet<Interval> set;
    public SummaryRanges() {
        set = new TreeSet<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
    }

    public void addNum(int val) {
        Interval curr = new Interval(val, val),
                left = set.floor(curr), right = set.higher(curr);
        if (left != null) {
            if (left.end >= val) {
                return;
            } else if (left.end == val - 1) {
                curr.start = left.start;
                set.remove(left);
            }
        }
        if (right != null) {
            if (right.start == val + 1) {
                curr.end = right.end;
                set.remove(right);
            }
        }
        set.add(curr);
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(set);
    }


}