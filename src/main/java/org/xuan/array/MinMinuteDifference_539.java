package org.xuan.array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 3/26/17.
 */
public class MinMinuteDifference_539 {
    public int findMinDifference(List<String> timePoints) {
        Time[] times = new Time[timePoints.size()];
        for(int i = 0; i < times.length; i++) {
            times[i] = new Time(timePoints.get(i));
        }
        Arrays.sort(times);
        int result = times[0].diff(times[times.length - 1]);
        for(int i = 1; i < times.length; i++) {
            result = Math.min(times[i].diff(times[i - 1]), result);
        }
        return result;
    }

    private static class Time implements Comparable<Time>{
        final byte hour;
        final byte minute;
        private static final byte HOURS = 24, MINUTES = 60;
        public Time(String s) {
            String[] tokens = s.split(":");
            hour = Byte.parseByte(tokens[0]);
            minute = Byte.parseByte(tokens[1]);
        }

        @Override
        public int compareTo(Time o) {
            return this.hour == o.hour ? this.minute - o.minute : this.hour - o.hour;
        }

        public int diff(Time o) {
            if (this.compareTo(o) < 0) {
                return HOURS * MINUTES - o.diff(this);
            }
            return (hour - o.hour) * MINUTES + minute - o.minute;
        }
    }
}
