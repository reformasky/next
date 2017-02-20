package org.xuan.ints;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 2/17/17.
 */
public class BinaryWatch_401 {
    private int[] hour = new int[]{1,2,4,8}, minute = new int[]{1,2,4,8,16,32};
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        for(int i = Math.max(0, num - 5); i <= Math.min(3, num); i++) {
            List<Integer> hours = new ArrayList<>();
            get(i, 11, 0, hour.length - 1,  hour, hours);
            List<Integer> minutes = new ArrayList<>();
            get(num - i, 59, 0, minute.length - 1, minute, minutes);
            for(int h : hours) {
                for(int m : minutes) {
                    result.add(h + ":" + (m < 10 ? ("0" + m) : m));
                }
            }
        }
        return result;
    }

    private void get(int n, int max, int sum, int index, int[] vals, List<Integer> result) {
        if (n == 0) {
            result.add(sum);
        } else 	if (index >=0 ) {
            if (sum + vals[index] <= max) {
                get(n - 1, max, sum + vals[index], index - 1, vals, result);
            }
            get(n, max, sum, index - 1, vals, result);
        }
    }
}
