package org.xuan.array;

/**
 * Created by xzhou2 on 3/12/17.
 */
public class Teemo_495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        if (timeSeries.length == 0) {
            return result;
        }
        int pre = timeSeries[0];
        for(int i = 1; i < timeSeries.length; i++) {
            result += Math.min(duration, timeSeries[i] - pre);
            pre = timeSeries[i];
        }
        return result + duration;
    }
}
